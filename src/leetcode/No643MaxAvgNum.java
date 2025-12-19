package leetcode;

public class No643MaxAvgNum {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0; int j = k-1;
        double sum = 0; double maxAvg = 0;
        for(;i<=j;i++) sum += nums[i];
        maxAvg = sum / k;
        i = 0;
        for (;j<nums.length;){
            sum -= nums[i++];
            j++;
            if(j>=nums.length) break;
            sum += nums[j];
            double avg = sum / k;
            if(avg > maxAvg) maxAvg = avg;
        }
        return maxAvg;
    }
}
