package leetcode;

public class No53 {
    public int sumLeft(int[] nums, int left, int mid){
        int max = Integer.MIN_VALUE; int sum = 0;
        for(int i = mid; i>=left; i--){
            sum += nums[i]; max = Math.max(max, sum);
        }
        return max;
    }

    public int sumRight(int[] nums, int mid_add_1, int right){
        int max = Integer.MIN_VALUE; int sum = 0;
        for(int i=mid_add_1; i<=right; i++){
            sum += nums[i]; max = Math.max(max, sum);
        }
        return max;
    }

    public int maxNum(int[] nums, int left, int right){
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftSum = maxNum(nums, left, mid);
        int rightSUm = maxNum(nums, mid+1, right);
        int S1 = sumLeft(nums, left, mid);
        int S2  = sumRight(nums, mid+1, right);
        return Math.max(Math.max(leftSum ,rightSUm) , S1+S2);
    }

    public int maxSubArray(int[] nums) {
        return maxNum(nums, 0, nums.length-1);
    }
}
