def quick_sort(arr):
    if len(arr) <= 1
        return arr
    pivot = arr[0]  # 选取第一个元素作为基准元素
    left = [x for x in arr[1:] if x <= pivot]  # 将原数组小于基准元素的元素放在left数组里
    right = [x for x in arr[1:] if x > pivot]
    return quick_sort(left) + [pivot] + quick_sort(right)
