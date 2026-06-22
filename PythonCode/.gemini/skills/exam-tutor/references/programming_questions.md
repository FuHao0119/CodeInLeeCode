1. 设计贪心算法求最多相容活动集合，并说明排序依据。要求给出算法思想、关键步骤和Python伪代码。

   **算法思想**：贪心策略。按照活动结束时间升序排序，每次选择结束时间最早且与已选活动不冲突的活动。这样可以为后续活动留出尽可能多的时间。
   **关键步骤**：1. 按结束时间排序；2. 遍历活动，若开始时间 $\ge$ 上一个活动的结束时间，则选中该活动。
   **Python伪代码**：

   ```python
   def activity_select(items):
       items.sort(key=lambda x: x[1]) # 按结束时间排序
       ans = []
       last_end = -1
       for start, end in items:
           if start >= last_end:
               ans.append((start, end))
               last_end = end
       return ans
   ```

2. 设计回溯算法求给定集合中和为目标值t的所有子集。要求给出算法思想、关键步骤和Python伪代码。

   **算法思想**：深度优先搜索（DFS）+ 剪枝。从小到大尝试加入元素，若当前和等于目标值则记录；若超过则停止当前路径（剪枝）。
   **关键步骤**：1. 排序；2. 递归搜索；3. 剪枝逻辑。
   **Python伪代码**：

   ```python
   def solve(arr, t):
       ans = []
       arr.sort()
       def backtrack(start, path, current_sum):
           if current_sum == t:
               ans.append(path[:])
               return
           for i in range(start, len(arr)):
               if current_sum + arr[i] > t: break # 剪枝
               path.append(arr[i])
               backtrack(i + 1, path, current_sum + arr[i])
               path.pop() # 回溯
       backtrack(0, [], 0)
       return ans
   ```

3. 设计回溯算法求解n皇后问题，输出任意一个可行解。要求写出主要函数、测试样例和时间复杂度。

   **主要函数**：见下。
   **测试样例**：`solve_n_queens(4)` 输出 `[[1, 3, 0, 2], [2, 0, 3, 1]]`。
   **时间复杂度**：$O(N!)$。
   ```python
   def safe(cols, row, col):
       for r, c in enumerate(cols):
           if c == col or abs(row - r) == abs(col - c):
               return False
       return True

   def solve_n_queens(n):
       ans = []
       def backtrack(row, cols):
           if row == n:
               ans.append(cols[:]); return
           for col in range(n):
               if safe(cols, row, col):
                   cols.append(col)
                   backtrack(row + 1, cols)
                   cols.pop()
       backtrack(0, [])
       return ans
   ```

4. 设计二分查找算法，在有序列表中查找指定元素并返回其下标。要求给出算法思想、关键步骤和Python伪代码。

   **算法思想**：分治思想。不断将搜索区间减半。
   **关键步骤**：比较中间元素 `mid` 与目标值 `t`。
   **Python伪代码**：
   ```python
   def binary_search(arr, t):
       left, right = 0, len(arr) - 1
       while left <= right:
           mid = (left + right) // 2
           if arr[mid] == t: return mid
           elif arr[mid] < t: left = mid + 1
           else: right = mid - 1
       return -1
   ```

5. 设计快速排序算法，说明划分过程并完成排序。要求写出主要函数、测试样例和时间复杂度。

   **划分过程**：选取一个基准值（Pivot），将数组中小于基准的放左边，大于基准的放右边。
   **测试样例**：`quick_sort([4, 1, 5, 2])` -> `[1, 2, 4, 5]`。
   **时间复杂度**：平均 $O(N \log N)$，最坏 $O(N^2)$。
   ```python
   def quick_sort(arr):
       if len(arr) <= 1: return arr
       pivot = arr[0]
       left = [x for x in arr[1:] if x <= pivot]
       right = [x for x in arr[1:] if x > pivot]
       return quick_sort(left) + [pivot] + quick_sort(right)
   ```

6. 设计动态规划算法求0/1背包最大价值。要求写出主要函数、测试样例和时间复杂度。

   **主要函数**：
   ```python
   def knapsack(w, v, cap):
       n = len(w)
       dp = [[0]*(cap+1) for _ in range(n+1)]
       for i in range(1, n+1):
           for c in range(cap+1):
               dp[i][c] = dp[i-1][c]
               if c >= w[i-1]:
                   dp[i][c] = max(dp[i][c], dp[i-1][c-w[i-1]] + v[i-1])
       return dp[n][cap]
   ```
   **测试样例**：`knapsack([2,3], [3,4], 5)` -> `7`。
   **时间复杂度**：$O(N \times Cap)$。

7. 设计哈夫曼树构造算法，并计算带权路径长度。要求写出主要函数、测试样例 and 时间复杂度。

   **主要函数**：
   ```python
   import heapq
   def huffman_wpl(weights):
       heapq.heapify(weights)
       wpl = 0
       while len(weights) > 1:
           w1 = heapq.heappop(weights)
           w2 = heapq.heappop(weights)
           wpl += (w1 + w2)
           heapq.heappush(weights, w1 + w2)
       return wpl
   ```
   **测试样例**：`weights = [1, 2, 3]` -> `WPL = (1+2) + (3+3) = 9`。
   **时间复杂度**：$O(N \log N)$。

8. 设计归并排序算法，对整数序列进行递增排序。要求给出算法思想、关键步骤和Python伪代码。

   **算法思想**：分治。先递归分解成小数组，再合并有序数组。
   **关键步骤**：1. 分解（Divide）；2. 合并（Merge）。
   **Python伪代码**：
   ```python
   def merge_sort(arr):
       if len(arr) <= 1: return arr
       mid = len(arr) // 2
       left = merge_sort(arr[:mid])
       right = merge_sort(arr[mid:])
       return merge(left, right) # 合并两个有序列表
   ```

9. 设计递归算法计算正整数n的阶乘，并分析递归出口和递归调用关系。要求给出算法思想、关键步骤和Python伪代码。

   **递归出口**：`n <= 1` 时返回 `1`。
   **递归调用关系**：`fact(n) = n * fact(n-1)`。
   **Python伪代码**：
   ```python
   def fact(n):
       if n <= 1: return 1
       return n * fact(n - 1)
   ```

10. 描述旅行商问题的判定形式，并说明其与NP完全问题的关系。要求说明判定问题形式、证书验证、多项式时间验证，以及旅行商判定问题属于NP完全问题的理由。

    **判定形式**：是否存在一条经过所有城市且总长度 <= L 的回路？
    **证书验证**：证书是一个城市的排列序列。
    **多项式时间验证**：在 O(N) 时间内相加各城市间距离并判断是否 <= L。
    **属于NP完全的理由**：1. 它属于NP（可在多项式时间内验证）；2. 它是NP-Hard（哈密顿回路问题可规约到它）。

11. 设计动态规划算法求两个字符串的最长公共子序列长度。要求写出主要函数、测试样例和时间复杂度。

    **主要函数**：
    ```python
    def lcs(x, y):
        m, n = len(x), len(y)
        dp = [[0]*(n+1) for _ in range(m+1)]
        for i in range(1, m+1):
            for j in range(1, n+1):
                if x[i-1] == y[j-1]: dp[i][j] = dp[i-1][j-1] + 1
                else: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        return dp[m][n]
    ```
    **测试样例**：`lcs("ABC", "AC")` -> `2`。
    **时间复杂度**：$O(M \times N)$。

12. 设计分支限界算法求简单装载问题的最优装载重量。要求写出主要函数、测试样例和时间复杂度。

    **主要函数**：
    ```python
    import queue
    def max_loading(w, cap):
        q = queue.Queue(); q.put(0)
        best_w = 0
        for weight in w:
            for _ in range(q.qsize()):
                curr = q.get()
                if curr + weight <= cap:
                    best_w = max(best_w, curr + weight)
                    q.put(curr + weight)
                q.put(curr)
        return best_w
    ```
    **时间复杂度**：$O(2^N)$。

13. 设计动态规划算法求0/1背包最大价值。要求给出算法思想、关键步骤和Python伪代码。
    *(同第6题，重点在于思想描述)*
    **算法思想**：将大问题拆分为“选”或“不选”当前物品的子问题，记录中间状态。
    **关键步骤**：状态转移方程 `dp[i][c] = max(dp[i-1][c], dp[i-1][c-w[i]]+v[i])`。

14. 设计回溯算法求解n皇后问题，输出任意一个可行解。要求给出算法思想、关键步骤和Python伪代码。
    *(同第3题，重点在于思想描述)*
    **算法思想**：逐行放置皇后，通过冲突检查进行剪枝，若某行无法放置则回退。

15. 设计分支限界算法求简单装载问题的最优装载重量。要求给出算法思想、关键步骤和Python伪代码。
    *(同第12题)*
    **算法思想**：使用队列进行广度优先搜索，记录所有可能的装载重量，实时更新最大值。

16. 设计动态规划算法求两个字符串的最长公共子序列长度。要求给出算法思想、关键步骤和Python伪代码。
    *(同第11题)*
    **关键步骤**：构建二维数组 `dp`，若字符相同则 `+1`，不同则取上方或左方的最大值。

17. 设计贪心算法求最多相容活动集合，并说明排序依据。要求写出主要函数、测试样例和时间复杂度。
    *(同第1题)*
    **排序依据**：按活动**结束时间**升序排序。
    **时间复杂度**：$O(N \log N)$。

18. 设计归并排序算法，对整数序列进行递增排序。要求说明状态/约束设计、核心代码和结果输出。
    **状态设计**：递归分解直到序列长度为1。
    **核心代码**：`merge` 函数负责合并两个有序序列。
    **结果输出**：递增排列的数组。
