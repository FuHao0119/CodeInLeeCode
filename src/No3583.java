import java.math.BigInteger;
import java.util.*;

public class No3583 {

    public int specialTriplets_(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>(); // <val, [index1, index2...]>
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        map.forEach((k,v)->{
            System.out.println("key: " + k + "  v: " + v);
        });

        int mid = 0; int count = 0;
        while(mid < nums.length) {
            int value = nums[mid] * 2;
            List<Integer> index_list = map.get(value);
            if(index_list == null){
                System.out.println("中心数为:" + nums[mid] + "时，没有特殊三元组。");mid++; continue;
            }

            int insertionPoint = Collections.binarySearch(index_list, mid);
            if (insertionPoint < 0) {
                insertionPoint = -(insertionPoint + 1);
            }

            long leftCount = insertionPoint;


            int equalCount = 0;
            if (index_list.size() > leftCount && index_list.get((int)leftCount) == mid) {

                int searchNext = Collections.binarySearch(index_list, mid + 1);
                int endPoint = (searchNext >= 0) ? searchNext : -(searchNext + 1);
                equalCount = endPoint - (int)leftCount;
            }
            long rightCount = index_list.size() - leftCount - equalCount;


//            int leftCount = 0, rightCount = 0;
//            for(int i = 0; i < index_list.size(); i++) {
//                int index = index_list.get(i);
//                if(index < mid) {
//                    leftCount = (int) (leftCount % (Math.pow(10,9) + 7));
//                    leftCount++;
//                }
//                else if(index > mid){
//                    rightCount = (int) (rightCount % (Math.pow(10,9) + 7));
//                    rightCount++;
//                }
//            }

//            for(int index : index_list) {
//                if(index < mid) leftCount++;
//                else if(index > mid) rightCount++;
//            }

            count += (int) ((leftCount * rightCount) % (Math.pow(10,9) + 7));
            System.out.println("中心数为:" + nums[mid] + "时 leftCount: " + leftCount + " rightCount: " + rightCount);
            mid++;
        }

        return count;
    }
    public int specialTriplets(int[] nums) {
        int mid = 0; int count = 0;
        while(mid < nums.length){

            int leftCount = 0;
            for(int left = 0; left < mid; left++){
                if(nums[left] == nums[mid]*2){
                    leftCount++;
                }
            }

            int rightCount = 0;
            for (int right = mid + 1; right < nums.length; right++){
                if(nums[right] == nums[mid]*2){
                    rightCount++;
                }
            }

            if(leftCount ==0 || rightCount ==0){
                mid++; continue;
            }else{
                count += (int) ((leftCount * rightCount) % (Math.pow(10,9) + 7));
            }

            mid++;
        }

        return count;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,0,0};
        int count = new No3583().specialTriplets_(nums);
        System.out.println(count);
    }
}

