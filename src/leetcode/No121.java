package leetcode;

public class No121 {
    public int maxProfit(int[] prices) {
        int min = prices[0]; int min_index = 0;
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            int tmp = prices[i] - min;
            if(tmp < 0){
                min = prices[i]; min_index = i;
            }else{
                if(tmp > max) max = tmp;
            }

            if(prices[i] < min) {
                min = prices[i];
                min_index = i;
            }
        }

        return max;
    }
}
