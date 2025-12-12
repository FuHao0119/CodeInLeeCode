package sdju_exam;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        boolean flag = false;
        for (int num : numbers) {
            if(num % 3 != 0) flag = false;
            if(num % 3 == 0){
                if(flag == true){
                    System.out.println("YES");
                    return;
                }
                flag = true;
            }
        }


        System.out.println("NO");
    }
}
