import queue

# 简单装载问题 (分支限界法)
def max_loading(weights, cap):
    n = len(weights)
    q = queue.Queue()
    q.put(0)  # 初始重量
    best_w = 0
    
    for i in range(n):
        size = q.qsize()
        for _ in range(size):
            curr_w = q.get()
            # 选项1: 装入第i个集装箱
            if curr_w + weights[i] <= cap:
                new_w = curr_w + weights[i]
                if new_w > best_w:
                    best_w = new_w
                q.put(new_w)
            # 选项2: 不装入第i个集装箱
            q.put(curr_w)
            
    return best_w

# 测试
weights = [10, 20, 30]
cap = 35
assert max_loading(weights, cap) == 30
print("Max Loading (Branch & Bound) passed")
