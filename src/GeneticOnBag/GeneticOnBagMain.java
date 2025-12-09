package GeneticOnBag;

import java.lang.reflect.Array;
import java.util.*;

class Item {
    String name;
    Integer weight;
    Integer survivalPoints;

    public Item() {
    }

    public Item(String name, Integer weight, Integer survivalPoints) {
        this.name = name;
        this.weight = weight;
        this.survivalPoints = survivalPoints;
    }
}

public class GeneticOnBagMain {
    static final Integer MAXWEIGHT = 30;  // 最大重量
    static final Double MUTATION_PROBABILITY = 0.005;  // 变异概率
    static final int ROUND = 1000000;

    // 适应值函数
    private static Integer[] getFitness_(Integer[][] as, Item[] items) {
        Integer[] fitnesses = new Integer[as.length];
        for(int j=0; j<as.length; j++){
            Integer fitness = 0; Integer weight = 0;
            for(int i=0; i<as[j].length; i++){
                if(as[j][i] == 1) {
                    fitness += items[i].survivalPoints;
                    weight += items[i].weight;
                }
            }
            if(weight > MAXWEIGHT) {fitnesses[j] = 0;}
            else {fitnesses[j] = fitness;}

        }
        return fitnesses;
    }

    // 找到一个map中最大的key以及对应value
    static Map<String, Object> getMaxFitnessAndCode(Map<Integer, Integer[]> fitnessAndCodeMap) {
        Map<String, Object> map = new HashMap<>();
        Integer maxFitness = 0;
        Integer[] maxFitnessCode = null;
        for(Map.Entry<Integer, Integer[]> entry : fitnessAndCodeMap.entrySet()){
            if (entry.getKey() > maxFitness) {
                maxFitness = entry.getKey();
                maxFitnessCode = Arrays.copyOf(entry.getValue(), entry.getValue().length);
            }
        }
        map.put("maxFitness", maxFitness);
        map.put("maxFitnessCode", maxFitnessCode);
        return map;
    }

    // 根据随机数 选择个体
    static int chooseA(Double[] sum_probabilitys, double r){
        int i = 0;
        for(; i<sum_probabilitys.length; i++){
            if(r < sum_probabilitys[i]){
                return i;
            }
        }
        return i-1;
    }

    // 将两个个体交叉 产生两个后代 (单点交叉)
    static void cross(Integer[] a1, Integer[] a2){
        Integer[] b1 = new Integer[a1.length];
        Integer[] b2 = new Integer[a2.length];
        int mid = a1.length / 2;

        for(int i = 0; i < a1.length; i++){
            if(i < mid){
                b1[i] = a1[i];
                b2[i] = a2[i];
            } else {
                b1[i] = a2[i];
                b2[i] = a1[i];
            }
        }
        System.arraycopy(b1,0,a1,0,a1.length);
        System.arraycopy(b2,0,a2,0,a2.length);
    }

    // 根据概率变异
    static void mutate(Integer[] a){
        if(Math.random() < MUTATION_PROBABILITY){
            int randomIndex = (int)(Math.random() * a.length); // 随机选择变异位置
            a[randomIndex] = a[randomIndex] == 1 ? 0 : 1;
        }
    }

    static double sum(Integer... fs){
        double sum = 0;
        for(int i=0; i<fs.length; i++){
            sum += fs[i];
        }
        return sum;
    }

    static Integer getWeight(Integer[] code, Item[] items){
        Integer weight = 0;
        for (int i = 0; i < items.length; i++) {
            if (code[i] == 1) {  // 只有当该物品被选中时才加重量
                weight += items[i].weight;
            }
        }
        return weight;
    }

//    public static void main(String[] args) {
//        // 物品列表
//        Item item1 = new Item("睡袋", 15, 15);
//        Item item2 = new Item("绳子", 3, 7);
//        Item item3 = new Item("小刀", 2, 10);
//        Item item4 = new Item("手电筒", 5, 5);
//        Item item5 = new Item("瓶子", 9, 8);
//        Item item6 = new Item("葡萄糖", 20, 17);
//        Item[] items = {item1, item2, item3, item4, item5, item6};
//
//        // 初始化群体
//        Integer[] A1 = {1,0,0,1,1,0};
//        Integer[] A2 = {0,0,1,1,1,0};
//        Integer[] A3 = {0,1,0,1,0,0};
//        Integer[] A4 = {0,1,1,0,0,0};
//        Integer[] A5 = {0,1,1,0,0,1};
//        Integer[] A6 = {0,0,1,0,0,1};
//        Integer[] A7 = {1,1,1,0,0,1};
//        Integer[] A8 = {0,1,0,1,0,1};
//
//        Integer[][] As = {A1, A2, A3, A4, A5, A6, A7, A8}; // 保存群体的数组
//
//        // 最大的fitness和个体编码
//        Integer maxFitness = 0;
//        Integer[] maxFitnessCode = {0,0,0,0,0,0};
//
//        // 迭代
//        for(int i=0; i<ROUND;i++){
//            // 计算所有的fitness
//            Integer[] fitnesses = getFitness_(As,items);
//
//            // 更新最大fitness和对应编码
//            Map<Integer, Integer[]> fitnessAndCodeMap = new HashMap<>();
//            for (int m = 0; m < fitnesses.length; m++) {
//                fitnessAndCodeMap.put(fitnesses[m], As[m]);
//            }
//
//            Map<String, Object> maxFitnessAndCodeARound = getMaxFitnessAndCode(fitnessAndCodeMap);
//            if((Integer) maxFitnessAndCodeARound.get("maxFitness")>maxFitness){
//                maxFitness = (Integer) maxFitnessAndCodeARound.get("maxFitness");
//                maxFitnessCode = (Integer[]) maxFitnessAndCodeARound.get("maxFitnessCode");
//            }
//
//            // 轮盘赌：通过概率和随机数选择两个个体
//            Double sumFitness = sum(fitnesses);
//            Double[] probabilitys = new Double[fitnesses.length];
//            for (int m = 0; m < fitnesses.length; m++) {
//                probabilitys[m] = fitnesses[0]/sumFitness;
//            }
//            Double[] sum_probabilitys = new Double[probabilitys.length]; Double sum = 0.0;
//            for(int j=0; j<probabilitys.length; j++){
//                sum += probabilitys[j];
//                sum_probabilitys[j] = sum;
//            }
//
//            double r1 = Math.random();
//            double r2 = Math.random();
//
//            // 根据随机数选个体
//            int A_index1 = chooseA(sum_probabilitys, r1);
//            int A_index2 = chooseA(sum_probabilitys, r2);
//
//            Integer[] child1 = Arrays.copyOf(As[A_index1], As[A_index1].length);
//            Integer[] child2 = Arrays.copyOf(As[A_index2], As[A_index2].length);
//
//            // 交叉和变异
//            cross(child1, child2);
//            mutate(child1);
//            mutate(child2);
//            // 新个体 取代种群中的老个体
//            System.arraycopy(child1, 0, As[A_index1], 0, As[A_index1].length);
//            System.arraycopy(child2, 0, As[A_index2], 0, As[A_index2].length);
//        }
//
//        System.out.println("迭代完成......");
//        System.out.println("重量: " + getWeight(maxFitnessCode, items) + "  生存点数: " + maxFitness );
//        System.out.println("对应的个体编码: " + Arrays.toString(maxFitnessCode));
//        System.out.println();
//    }



}