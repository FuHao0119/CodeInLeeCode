def binary_search(arr,num):
    left, right = 0, len(arr)-1
    while left < right:
        mid = (left+right)/2
        if(num==arr[mid]): return mid
        else if(num>=arr[mid]):
            left = mid+1
        else:
            right = mid-1

    return -1


