package week_exam_483;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class code2 {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        List<List<String>> res2 = new ArrayList<>();
        generatePermutations(words, 0, res);
//        System.out.println(res);
        for(List<String> item:res){
            /**
             * top[0] == left[0], top[3] == right[0]
             * bottom[0] == left[3], bottom[3] == right[3]©leetcode
             */
            if(item.get(0).charAt(0) == item.get(1).charAt(0) && item.get(0).charAt(3) == item.get(2).charAt(0)
            && item.get(3).charAt(0) == item.get(1).charAt(3) && item.get(3).charAt(3) == item.get(2).charAt(3))
            {
                res2.add(item);
            }
        }
        Collections.sort(res2, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> list1, List<String> list2) {
                // 逐个比较元素
                for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                    int cmp = list1.get(i).compareTo(list2.get(i));
                    if (cmp != 0) {
                        return cmp; // 找到第一个不同的元素就返回比较结果
                    }
                }
                // 如果所有对应元素都相同，比较长度
                return Integer.compare(list1.size(), list2.size());
            }
        });
        return res2;
    }

    public static void generatePermutations(String[] nums, int start, List<List<String>> result) {
        if (start == nums.length - 1) {
            List<String> permutation = new ArrayList<>();
            for (String num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            generatePermutations(nums, start + 1, result);
            swap(nums, start, i); // 回溯
        }
    }

    private static void swap(String[] nums, int i, int j) {
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"able","area","echo","also"};
        System.out.println(new code2().wordSquares(words));
    }
}
