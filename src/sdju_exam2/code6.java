package sdju_exam2;

import java.util.*;

public class code6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        if (n == 0) {
            return;
        }

        int[] prefixDistinctCounts = new int[n];
        int[] suffixDistinctCounts = new int[n];

        Set<Integer> uniqueElements = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueElements.add(a[i]);
            prefixDistinctCounts[i] = uniqueElements.size();
        }

        uniqueElements.clear();
        for (int i = n - 1; i >= 0; i--) {
            suffixDistinctCounts[i] = uniqueElements.size();
            uniqueElements.add(a[i]);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int diff = prefixDistinctCounts[i] - suffixDistinctCounts[i];
            if (i > 0) {
                result.append(" ");
            }
            result.append(diff);
        }

        System.out.println(result.toString());
    }
}
