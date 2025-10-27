public class No189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] nums_copy = new int[len];
        System.arraycopy(nums,0,nums_copy,0,len);
        // index = (i+k)%len
        int index = 0;
        for(int i = 0; i < len; i++){
            index = (i+k)%len;
            nums[index] = nums_copy[i];
        }
    }
}
