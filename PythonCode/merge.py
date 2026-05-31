def merge(a,b):
    # 归并两个表 a、b
    i=j=0
    ans=[]
    while i<len(a) and j<len(b):
        if a[i] <= b[j]:
            ans.append(a[i])
            i+=1
        elif a[i] > b[j]:
            ans.append(b[j])
            j+=1
    if i>j:
        ans.extend(b[j:])
    else:
        ans.extend(a[i:])
    return ans

arr = merge([1,4,8],[2,5,9])
print(arr)

