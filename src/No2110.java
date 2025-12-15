public class No2110 {
    public long getDescentPeriods(int[] prices) {
        if(prices.length == 1) return 1;
        int i = 0; int j = 1; int temp = prices[i];long count = 0;
        while(j < prices.length){
            if ((temp - prices[j]) == 1){
                if (j == prices.length - 1){
                    j++;
                    count += ((j-i) * (j-i -1)) / 2;
                    break;
                }
                temp = prices[j]; j++;

            }else{
                count += ((j-i) * (j-i -1)) / 2;
                i = j; temp = prices[i];j++;
            }
        }

        return count + prices.length;
    }
}
