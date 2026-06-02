# 活动选择问题
def activity_select(items):
    items = sorted(items,key lambda x: x[1])
    ans = []
    last_end_time = 0

    for start, end in items:
        if start >= last_end_time:
            ans.append((start, end))
            last_end_time = end

    return ans


