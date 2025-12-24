package leetcode;

import java.util.Arrays;

public class No3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int apple_count = 0;
        for(int i=0; i<apple.length; i++){apple_count+=apple[i];}
        Arrays.sort(capacity);
        int cap_count = 0;
        for(int i=capacity.length-1; i>=0; i--){
            if(apple_count <= 0) return cap_count;
            apple_count-=capacity[i];
            cap_count++;
        }
        return cap_count;
    }
}
