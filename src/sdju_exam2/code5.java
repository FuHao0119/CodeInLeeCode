package sdju_exam2;

import java.util.*;
import java.util.stream.Collectors;

public class code5 {
    public static void main(String[] args) {
        Map<Integer, Integer> map1 = new HashMap<>(); // {"题号"："提交次数"}
        Map<Integer, Integer> map2 = new HashMap<>(); // {"题号"："通过次数"}

        Scanner sc = new Scanner(System.in);
        int submitTotal = sc.nextInt();
        int questionTotal = sc.nextInt();

        for(int i = 1; i <= questionTotal; i++){
            map1.put(i, 0);
            map2.put(i, 0);
        }

        for(int i = 0; i < submitTotal; i++){
            int questionNumber = sc.nextInt();
            String result = sc.next();
            map1.put(questionNumber, map1.get(questionNumber) + 1);

            if(result.equals("AC")){
                map2.put(questionNumber, map2.get(questionNumber) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= questionTotal; i++){
            Integer a = map1.get(i);
            Integer b = map2.get(i);
            // b 除以 a
            double v = (double)b / a;
            if(v >= 0.5){
                list.add(i);
            }
        }

        if(list.size() == 0){
            System.out.println("-1");
        }else{
            String result = list.stream().map(Object::toString)
                                         .collect(Collectors.joining(" "));
            System.out.println(result);
        }
    }
}
