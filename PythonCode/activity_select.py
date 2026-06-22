# 活动选择问题 (贪心算法)
def activity_select(items):
    # items 是 (开始时间, 结束时间) 的列表
    # 贪心策略：按结束时间升序排序
    items = sorted(items, key=lambda x: x[1])
    ans = []
    last_end_time = -1

    for start, end in items:
        if start >= last_end_time:
            ans.append((start, end))
            last_end_time = end

    return ans

# 测试
items = [(1, 3), (2, 5), (4, 7), (6, 9)]
assert activity_select(items) == [(1, 3), (4, 7)]
print("Activity Select passed")
