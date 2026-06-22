**1. 快速排序划分**
```python
def partition(a, left, right):
    pivot = ________________
    i, j = left, right
    ________________:
        while i < j and a[j] >= pivot:
            j -= 1
        while i < j and a[i] <= pivot:
            i += 1
        ________________:
            a[i], a[j] = a[j], a[i]
    a[left], a[i] = a[i], a[left]
    ________________

arr = [5, 2, 7, 1, 4]
pos = partition(arr, 0, len(arr) - 1)
assert all(x <= arr[pos] for x in arr[:pos])
assert all(x >= arr[pos] for x in arr[pos + 1:])
print(arr, pos)
```
答案：
```python
def partition(a, left, right):
    pivot = a[left]
    i, j = left, right
    while i < j:
        while i < j and a[j] >= pivot:
            j -= 1
        while i < j and a[i] <= pivot:
            i += 1
        if i < j:
            a[i], a[j] = a[j], a[i]
    a[left], a[i] = a[i], a[left]
    return i
```

---

**2. 递归求和与归纳思想**
```python
def sum_to(n):
    if ________________:
        ________________
    return ________________ + ________________

assert sum_to(10) == 55
print(sum_to(10))
```
答案：
```python
def sum_to(n):
    if n == 1:
        return 1
    return sum_to(n - 1) + n
```

---

**3. 子集和回溯**
```python
def subset_sum(nums, target):
    ans, path = [], []
    def dfs(index, total):
        if ________________:
            ans.append(path.copy())
            return
        if ________________:
            return
        path.append(nums[index])
        dfs(index + 1, total + nums[index])
        path.pop()
        ________________
    dfs(0, 0)
    ________________

print(subset_sum([2, 3, 5, 7], 10))
```
答案：
```python
def subset_sum(nums, target):
    ans, path = [], []
    def dfs(index, total):
        if total == target:
            ans.append(path.copy())
            return
        if index == len(nums) or total > target:
            return
        path.append(nums[index])
        dfs(index + 1, total + nums[index])
        path.pop()
        dfs(index + 1, total)
    dfs(0, 0)
    return ans
```

---

**4. 最长公共子序列长度**
```python
def lcs(x, y):
    m, n = len(x), len(y)
    dp = ________________
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if ________________:
                dp[i][j] = ________________
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    ________________

assert lcs('ABCBDAB', 'BDCABA') == 4
print(lcs('ABCBDAB', 'BDCABA'))
```
答案：
```python
def lcs(x, y):
    m, n = len(x), len(y)
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if x[i - 1] == y[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    return dp[m][n]
```

---

**5. 0/1 背包分支限界**
```python
import heapq
def knapsack_bb(weights, values, cap):
    n = len(weights)
    best = 0
    heap = [(-sum(values), 0, 0, 0)]
    while heap:
        neg_bound, i, w, v = ________________
        if ________________:
            continue
        if ________________:
            new_v = v + values[i]
            best = max(best, new_v)
            heapq.heappush(heap, (-(new_v + sum(values[i + 1:])), i + 1, w + weights[i], new_v))
        heapq.heappush(heap, (-(v + sum(values[i + 1:])), i + 1, w, v))
    ________________

assert knapsack_bb([2, 3, 4], [3, 4, 5], 5) == 7
print(knapsack_bb([2, 3, 4], [3, 4, 5], 5))
```
答案：
```python
import heapq
def knapsack_bb(weights, values, cap):
    n = len(weights)
    best = 0
    heap = [(-sum(values), 0, 0, 0)]
    while heap:
        neg_bound, i, w, v = heapq.heappop(heap)
        if -neg_bound <= best or i == n:
            continue
        if w + weights[i] <= cap:
            new_v = v + values[i]
            best = max(best, new_v)
            heapq.heappush(heap, (-(new_v + sum(values[i + 1:])), i + 1, w + weights[i], new_v))
        heapq.heappush(heap, (-(v + sum(values[i + 1:])), i + 1, w, v))
    return best
```

---

**6. n 皇后安全判断**
```python
def safe(cols, row, col):
    ________________
        if ________________ or ________________:
            return False
    ________________

cols = [1, 3, 0]
assert safe(cols, 3, 2) is True
print(safe(cols, 3, 2))
```
答案：
```python
def safe(cols, row, col):
    for r, c in enumerate(cols):
        if c == col or abs(row - r) == abs(col - c):
            return False
    return True
```

---

**7. 顺序求和**
```python
def solve(n):
    ________________
    for i in ________________:
        ________________
    ________________

assert solve(13) == 91
print(solve(13))
```
答案：
```python
def solve(n):
    total = 0
    for i in range(1, n + 1):
        total += i
    return total
```

---

**8. 快速排序划分思想**
```python
def quick_sort(a):
    ________________
        return a
    ________________
    left = [x for x in a[1:] if ________________]
    right = [x for x in a[1:] if x > pivot]
    return ________________

assert quick_sort([4, 1, 5, 2]) == [1, 2, 4, 5]
print(quick_sort([4, 1, 5, 2]))
```
答案：
```python
def quick_sort(a):
    if len(a) <= 1:
        return a
    pivot = a[0]
    left = [x for x in a[1:] if x <= pivot]
    right = [x for x in a[1:] if x > pivot]
    return quick_sort(left) + [pivot] + quick_sort(right)
```

---

**9. 0/1 背包**
```python
def knapsack(weights, values, cap):
    n = len(weights)
    dp = ________________
    for i in range(1, n + 1):
        for c in range(cap + 1):
            ________________
            if ________________:
                dp[i][c] = max(dp[i][c], dp[i - 1][c - weights[i - 1]] + values[i - 1])
    ________________

assert knapsack([2, 3, 4], [3, 4, 5], 5) == 7
print(knapsack([2, 3, 4], [3, 4, 5], 5))
```
答案：
```python
def knapsack(weights, values, cap):
    n = len(weights)
    dp = [[0] * (cap + 1) for _ in range(n + 1)]
    for i in range(1, n + 1):
        for c in range(cap + 1):
            dp[i][c] = dp[i - 1][c]
            if c >= weights[i - 1]:
                dp[i][c] = max(dp[i][c], dp[i - 1][c - weights[i - 1]] + values[i - 1])
    return dp[n][cap]
```

---

**10. 活动选择**
```python
def activity_select(items):
    items = ________________
    ans = []
    ________________
    for start, end in items:
        if ________________:
            ans.append((start, end))
            ________________
    return ans

items = [(1, 3), (2, 5), (4, 7), (6, 9)]
assert activity_select(items) == [(1, 3), (4, 7)]
print(activity_select(items))
```
答案：
```python
def activity_select(items):
    items = sorted(items, key=lambda x: x[1])
    ans = []
    last_end = -1
    for start, end in items:
        if start >= last_end:
            ans.append((start, end))
            last_end = end
    return ans
```

---

**11. 阶乘递归**
```python
def fact(n):
    ________________
    ________________
    return ________________

assert fact(8) == 40320
________________
```
答案：
```python
def fact(n):
    if n <= 1:
        return 1
    return n * fact(n - 1)

print(fact(8))
```

---

**12. 二分查找**
```python
def binary_search(a, target):
    ________________
    ________________
    ________________
        if a[mid] == target:
            return mid
        if a[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1

arr = [1, 3, 5, 7, 9]
assert binary_search(arr, 7) == 3
print(binary_search(arr, 7))
```
答案：
```python
def binary_search(a, target):
    left, right = 0, len(a) - 1
    while left <= right:
        mid = (left + right) // 2
        if a[mid] == target:
            return mid
        if a[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1
```

---

**13. 归并两个有序表**
```python
def merge(a, b):
    ________________
    ans = []
    ________________
        if a[i] <= b[j]:
            ans.append(a[i]); i += 1
        else:
            ans.append(b[j]); j += 1
    ________________
    ans.extend(b[j:])
    ________________

assert merge([1, 4, 8], [2, 3, 9]) == [1, 2, 3, 4, 8, 9]
print(merge([1, 4, 8], [2, 3, 9]))
```
答案：
```python
def merge(a, b):
    i = j = 0
    ans = []
    while i < len(a) and j < len(b):
        if a[i] <= b[j]:
            ans.append(a[i]); i += 1
        else:
            ans.append(b[j]); j += 1
    ans.extend(a[i:])
    ans.extend(b[j:])
    return ans
```
