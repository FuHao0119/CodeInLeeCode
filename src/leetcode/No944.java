package leetcode;

import java.util.Arrays;

public class No944 {
    public int minDeletionSize(String[] strs) {
        int width = strs[0].length();  // 宽
        int height = strs.length;  // 高

        int count = 0;
        for(int i = 0; i < width; i++){
            char[] chars = new char[height];
            for(int j = 0; j < height; j++){
                chars[j] = strs[j].charAt(i);
            }
            char[] old_chars = chars.clone();
            Arrays.sort(chars);
            if(!Arrays.equals(old_chars, chars)){
                count++;
            }
        }
        return count;
    }
}
