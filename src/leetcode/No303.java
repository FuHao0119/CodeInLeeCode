package leetcode;

import java.util.Arrays;

public class No303 {
        int[] arr = null;
        int[] sum_arr = null;

        public void NumArray(int[] nums) {
            arr = nums;
            sum_arr = nums;
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum += arr[i];
                sum_arr[i] = sum;
            }
            System.out.println(Arrays.toString(sum_arr));
        }

        public int sumRange(int left, int right) {
            return sum_arr[right] - (
                    left-1<0 ? 0 : sum_arr[left-1]
            );
        }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
