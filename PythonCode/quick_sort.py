# 快速排序
def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[0]  # 选取第一个元素作为基准
    left = [x for x in arr[1:] if x <= pivot]
    right = [x for x in arr[1:] if x > pivot]
    return quick_sort(left) + [pivot] + quick_sort(right)

# 测试
assert quick_sort([4, 1, 5, 2]) == [1, 2, 4, 5]
print("Quick Sort passed")
