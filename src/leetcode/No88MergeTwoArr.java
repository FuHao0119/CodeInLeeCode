package leetcode;

import java.util.Arrays;

public class No88MergeTwoArr {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        System.arraycopy(nums1,0, nums3,0,m);
        int p2 = 0; int p3 = 0;
        int i=0;
        for(; i<m+n; i++){
            if(p2 >= n || p3 >= m) break;
            if(nums2[p2] < nums3[p3]){
                nums1[i] = nums2[p2++];
            }else{
                nums1[i] = nums3[p3++];
            }
        }

        while (p3 < m && i<m+n) {
            nums1[i++] = nums3[p3++];
        }

        while (p2 < n && i<m+n) {
            nums1[i++] = nums2[p2++];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new No88MergeTwoArr().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
