package sdju_exam;

import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int min = s + t;
        for(int i = 1; i < n; i++){
            s = scanner.nextInt();
            t = scanner.nextInt();
            int num = s + t;
            if(num < min) min = num;
        }
        System.out.println(min);
        scanner.close();
    }
}
