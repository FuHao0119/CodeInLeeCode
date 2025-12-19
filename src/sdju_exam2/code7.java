package sdju_exam2;

import java.util.*;

public class code7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int S_i = sc.nextInt();
        int S_j = sc.nextInt();
        int E_i = sc.nextInt();
        int E_j = sc.nextInt();

        List<String> maze = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            maze.add(sc.next());
        }
        sc.close();

        int[][] direction = new int[][]{
                {0, -1}, // 左
                {0, 1},  // 右
                {-1, 0}, // 上
                {1, 0}   // 下
        };

        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        queue.add(new int[]{S_i, S_j});
        dist[S_i][S_j] = 0;

        int shortestPath = -1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            if (x == E_i && y == E_j) {
                shortestPath = dist[x][y];
                break;
            }

            for (int[] dir : direction) {
                int dx = x + dir[0];
                int dy = y + dir[1];

                if (dx >= 0 && dx < n && dy >= 0 && dy < m && maze.get(dx).charAt(dy) != '#' && dist[dx][dy] == -1) {
                    dist[dx][dy] = dist[x][y] + 1;
                    queue.add(new int[]{dx, dy});
                }
            }
        }

        System.out.println(shortestPath);
    }
}
