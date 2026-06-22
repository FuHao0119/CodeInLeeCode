# 归并排序实现
def merge_sort(arr):
    if len(arr) == 1:
        return arr
    mid = len(arr) // 2
    left_arr = arr[:mid]
    right_arr = arr[mid:]
    merged_left_arr = merge_sort(left_arr)
    merged_right_arr = merge_sort(right_arr)
    return merge_arr(merged_left_arr, merged_right_arr)

def merge_arr(arr1, arr2):
    i,j = 0,0
    res = []
    while i<len(arr1) and j<len(arr2):
        if arr1[i] <= arr2[j]:
            res.append(arr1[i])
            i+=1 
        else:
            res.append(arr2[j])
            j+=1 

    res.extend(arr1[i:])
    res.extend(arr2[j:])
    return res

arr = [34, 50, 14, 61, 32, 11, 80, 1, 100]
print(merge_sort(arr))
