public class No1015 {
    public int smallestRepunitDivByK(int k) {
        if(k%2 == 0) return -1;
        if(k%5==0) return -1;

        int num = 1;
        int length = 1;

        while( (num %= k) != 0 ) {
            num = num * 10 + 1;
            length++;

            if (length > k) {
                return -1;
            }
        }

        return length;
    }
}
