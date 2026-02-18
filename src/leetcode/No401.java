package leetcode;

public class No401 {
    public List<String> readBinaryWatch(int turnedOn) {
        // 我们可以枚举小时的所有可能值 [0,11]，以及分钟的所有可能值 [0,59]，并计算二者的二进制中 1 的个数之和，若为 turnedOn，则将其加入到答案中。
        List<String> list_str = new ArrayList<String>();

        for (int i = 0; i < 12; i++){ // 小时
            for (int j = 0; j < 60; j++){
                int i_count = Integer.bitCount(i);
                int j_count = Integer.bitCount(j);
                if((i_count + j_count) == turnedOn){
                    String j_str  = null;
                    if(j < 10) j_str = "0"+j;
                    else j_str = j+"";
                    list_str.add(i+":"+j_str);
                }
            }
        }
        return list_str;
    }
}
