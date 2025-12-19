package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No2841 {
    public long countDiffNum(List<Integer> nums, int l, int r){
        List<Integer> list = new ArrayList<>();
        for(int i = l; i <= r; i++){
            list.add(nums.get(i));
        }
        Set<Integer> numSet = new HashSet<>(list);
        return (long)numSet.size();
    }

    public long getSum(List<Integer> nums, int l, int r){
        long sum = 0;
        for(int i = l; i <= r; i++){
            sum += nums.get(i);
        }
        return sum;
    }

    public long maxSum(List<Integer> nums, int m, int k) {
        int l = 0; int r = k-1; long maxSum = 0; long sum = 0;
        long diffCount = countDiffNum(nums,l,r);
        if(diffCount >= m) {
            sum = getSum(nums,l,r);
            maxSum = Math.max(maxSum, sum);
        }
        while(r < nums.size()){
            diffCount = countDiffNum(nums,l,r);
            if(diffCount >= m) {
                sum = getSum(nums,l,r);
                maxSum = Math.max(maxSum, sum);
            }
            l++;r++;
        }
        return maxSum;
    }
}
















