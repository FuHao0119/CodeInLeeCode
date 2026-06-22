# 归并两个有序列表
def merge(a, b):
    i = j = 0
    ans = []
    while i < len(a) and j < len(b):
        if a[i] <= b[j]:
            ans.append(a[i])
            i += 1
        else:
            ans.append(b[j])
            j += 1
    # 将剩余部分加入
    ans.extend(a[i:])
    ans.extend(b[j:])
    return ans

# 测试
assert merge([1, 4, 8], [2, 3, 9]) == [1, 2, 3, 4, 8, 9]
print("Merge passed")
