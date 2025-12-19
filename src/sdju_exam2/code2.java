package sdju_exam2;

import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int maxNum = 59049;
        if(maxNum % num == 0){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
        scanner.close();
    }
}
