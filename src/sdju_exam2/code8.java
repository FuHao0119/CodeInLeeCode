package sdju_exam2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class code8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        /*
         x x x x
         x x x x
         x x x x
         x x x x
         */


        // 解决上三角 不带对角线
        // 01 12 23
        // 02 13
        // 03
        for (int k = 1; k < n; k++) {
            List<Integer> x_y = new ArrayList<>();
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                x_y.add(arr[i][j]);
            }
            // 右上三角要求升序排列
            Collections.sort(x_y);
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                arr[i][j] = x_y.get(i);
            }
        }

        // 解决下三角 带对角线
        for (int k = 0; k < n; k++) {
            List<Integer> x_y = new ArrayList<>();
            // 收集对角线上的元素
            for (int i = k; i < n; i++) {
                int j = i - k;
                if (j >= 0 && j < n) {
                    x_y.add(arr[i][j]);
                }
            }
            // 左下三角要求降序排列
            x_y.sort(Collections.reverseOrder());
            // 将排序后的元素放回
            for (int i = k; i < n; i++) {
                int j = i - k;
                if (j >= 0 && j < n) {
                    arr[i][j] = x_y.get(i - k);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
