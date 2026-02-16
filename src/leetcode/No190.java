package leetcode;

class No190{
    public int reverseBits(int n) {
        String num = Integer.toBinaryString(n);
        System.out.println(num);
        int x = 1; int sum = 0;
        if(num.length() < 32){
            int j = 32 - num.length();
            for(int i = 0; i<j; i++){
                sum += (x*0);
                x *= 2;
            }
        }
        for(int i = 0; i<num.length(); i++){
            int newN = num.charAt(i) - '0';
            sum += (x*newN);
            x *= 2;
        }

        return sum;
    }
}
