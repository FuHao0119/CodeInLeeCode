# 归并排序
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

def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)

# 测试
assert merge_sort([4, 1, 5, 2, 3]) == [1, 2, 3, 4, 5]
print("Merge Sort passed")
