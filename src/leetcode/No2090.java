package leetcode;

import java.util.Arrays;

public class No2090 {
    public int[] getAverages(int[] nums, int k) {
        int[] avgs = new int[nums.length];
        long sum = 0;

        Arrays.fill(avgs,-1);
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            if(i<2*k) continue;
            avgs[i-k] = (int) (sum / (2*k+1));
            sum -= nums[i-2*k];
        }

        return avgs;
    }
}
