package leetcode;

import java.util.HashSet;
import java.util.Set;

public class No2154 {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums){
            set.add(num);
        }
        while(set.contains(original)){
            original *= 2;
        }
        return original;
    }
}
