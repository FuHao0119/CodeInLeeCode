package leetcode;

public class No2379 {
    public int minimumRecolors(String blocks, int k) {
        char[] blocksArr = blocks.toCharArray();
        int l = 0; int r = 0;

        int maxCount = 0; int count = 0;

        while(r<k-1){
            if(blocksArr[r] == 'B') {
                count++;
            }
            r++;
            maxCount = Math.max(maxCount,count);
        }

        while(r<blocksArr.length)
        {

            if(blocksArr[r] == 'B') {
                count++;
            }
            r++;
            if(blocksArr[l] == 'B'){
                count--;
            }
            l++;
            maxCount = Math.max(maxCount,count);
        }

        return k - maxCount;
    }
}
