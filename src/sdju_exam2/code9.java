package sdju_exam2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class code9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] minWishes = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            minWishes[i] = sc.nextLong();
        }

        List<List<Integer>> partnerLists = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            partnerLists.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            partnerLists.get(u).add(v);
            partnerLists.get(v).add(u);
        }
        sc.close();

        boolean[] visited = new boolean[n + 1];
        long totalAmount = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                List<Integer> currentGroup = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();

                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int person = queue.poll();
                    currentGroup.add(person);
                    for (int partner : partnerLists.get(person)) {
                        if (!visited[partner]) {
                            visited[partner] = true;
                            queue.add(partner);
                        }
                    }
                }

                long requiredAmountForGroup = 0;
                for (int personInGroup : currentGroup) {
                    if (minWishes[personInGroup] > requiredAmountForGroup) {
                        requiredAmountForGroup = minWishes[personInGroup];
                    }
                }
                
                totalAmount += (long)currentGroup.size() * requiredAmountForGroup;
            }
        }
        System.out.println(totalAmount);
    }
}
