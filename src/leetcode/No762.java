class No762 {
public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        // 核心：检查到sqrt(n)，且只检查6k±1形式的数
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i=left; i<=right; i++){
            int len = Integer.toBinaryString(i).replace("0","").length();
            System.out.println(len);
            if(isPrime(len)) count++;
        }

        return count;
    }
}
