package mindscope_exam;

import java.util.Scanner;
public class test3 {
    public int numTrees(int n){
        if(n<=1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i<=n;i++){
            for(int j=1; j<=i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(new test3().numTrees(n));
    }
}
