import heapq

# 哈夫曼树带权路径长度 (WPL)
def huffman_wpl(weights):
    # 使用最小堆模拟构造哈夫曼树
    heap = weights[:]
    heapq.heapify(heap)
    wpl = 0
    while len(heap) > 1:
        # 取出两个最小的权值
        w1 = heapq.heappop(heap)
        w2 = heapq.heappop(heap)
        # 合并后的新权值
        combined = w1 + w2
        wpl += combined
        heapq.heappush(heap, combined)
    return wpl

# 测试
weights = [5, 29, 7, 8, 14, 23, 3, 11]
# 构造过程中产生的合并节点权值之和即为WPL
print(f"Huffman WPL for {weights}: {huffman_wpl(weights)}")
