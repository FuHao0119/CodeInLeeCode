package mindscope_exam;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); int n = sc.nextInt();
        if(m > 9 || n > 9) {
            System.out.println("-1");
            return;
        }

        int[][] maze = new int[m][n];
        System.out.println("0");


        int x1 = sc.nextInt();int y1 = sc.nextInt();
        int x2 = sc.nextInt();int y2 = sc.nextInt();

        if(x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0 || x1 >= m || x2 >= m || y1 >= n || y2 >= n) {
            System.out.println("-1");
        } else {
            int tmp = maze[x1][y1];
            maze[x1][y1] = maze[x2][y2];
            maze[x2][y2] = tmp;
            System.out.println("0");
        }

        int x_up = sc.nextInt(); // 在第x_up行上面插入一行
        if(x_up < 0 || x_up > m){
            System.out.println("-1");
        } else {
//            m += 1;
//            maze = new int[m][n];
            System.out.println("0");
        }

        int y_left = sc.nextInt();  // 在第y_left列左边加一行
        if(y_left < 0 || y_left > n){
            System.out.println("-1");
        } else {
//            n += 1;
//            maze = new int[m][n];
            System.out.println("0");
        }

        int find_x = sc.nextInt(); int find_y = sc.nextInt();
        if (find_x < 0 || find_x >= m || find_y < 0 || find_y >= n) {
            System.out.println("-1");
        }else{
            System.out.println("0");
        }


        sc.close();

    }
}
