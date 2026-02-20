package leetcode;

public class No696 {
    public int countBinarySubstrings(String s) {
        if(s.length() <= 1) return 0;
        int center_left = 0; int center_right = 1; int count = 0;
        while(center_right < s.length()){
            if(s.charAt(center_left) != s.charAt(center_right)) {
                count++;
                int move_left = center_left-1; int move_right = center_right + 1;
                while(move_left >= 0 && move_right < s.length()
                        && s.charAt(move_left)==s.charAt(center_left)
                        && s.charAt(move_right)==s.charAt(center_right)
                ){
                    count++; move_left--; move_right++;
                }
            }
            center_left++;center_right++;
        }
        return count;
    }
}
