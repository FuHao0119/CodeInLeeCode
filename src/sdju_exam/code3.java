package sdju_exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 0; i < n; i++){

            if(i % 2 == 0){
                int num = 0;
                for(int j = 0; j < n; j++){
                    System.out.print(num);
                    num++; num %= 2;
                }
            } else {
                int num = 1;
                for(int j = 0; j < n; j++){
                    System.out.print(num);
                    num++; num %= 2;
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
