package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int base = 0;
        while(base < nums.length-1){
            if(base >0 && nums[base] == nums[base-1]) {base++; continue;}
            int l = base+1; int r = nums.length-1;

            while(l<r){
                if(nums[l] + nums[r] + nums[base] < 0) l++;
                else if(nums[l] + nums[r] + nums[base] > 0) r--;
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[base]); list.add(nums[l]);list.add(nums[r]);
                    res.add(list);
                    while(l<r && nums[r-1] == nums[r]) r--;
                    while(l<r && nums[l+1] == nums[l]) l++;
                    l++;r--;
                }
            }
            base++;
        }

        return res;
    }
}
