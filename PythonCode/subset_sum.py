# 子集和问题 (回溯法)
def subset_sum(arr, target):
    ans = []
    arr.sort()
    def backtrack(start, path, current_sum):
        if current_sum == target:
            ans.append(path[:])
            return
        for i in range(start, len(arr)):
            if current_sum + arr[i] > target:
                break  # 剪枝
            path.append(arr[i])
            backtrack(i + 1, path, current_sum + arr[i])
            path.pop()  # 回溯
    backtrack(0, [], 0)
    return ans

# 测试
assert subset_sum([1, 2, 3, 4, 5], 5) == [[1, 4], [2, 3], [5]]
print("Subset Sum passed")
