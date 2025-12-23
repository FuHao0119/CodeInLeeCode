package leetcode;

public class No2054 {
    public int maxTwoEvents(int[][] events) {
        int value = events[0][2];
        for(int i = 0; i < events.length; i++){
            int[] event_base = events[i];
            value = Math.max(value, event_base[2]);
            int start_time = event_base[0]; int end_time = event_base[1];
            for (int j = i+1; j < events.length; j++){
                int start_time_j = events[j][0]; int end_time_j = events[j][1];
                if(end_time < start_time_j || start_time > end_time_j){
                    value = Math.max(value, event_base[2] + events[j][2]);
                }
            }
        }

        return value;
    }
}
