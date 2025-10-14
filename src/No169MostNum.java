import java.util.HashMap;
import java.util.Map;

public class No169MostNum {
    public int majorityElement(int[] nums) {
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        final int[] maxValue = {0};
        final int[] maxKey = {0};

        map.forEach((k,v)->{
            if(v > maxValue[0]){
                maxValue[0] = v;
                maxKey[0] = k;
            }
        });

        return maxKey[0];
    }


}
