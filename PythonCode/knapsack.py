# 01背包问题
def knapsack(weights, values, cap):
    # weights: 物品重量列表, values: 物品价值列表, cap: 背包最大容量
    n = len(weights)
    dp = [[0] * (cap + 1) for _ in range(n + 1)]
    # dp[i][c] 表示考虑前i个物品，容量为c时的最大价值
    for i in range(1, n + 1):
        for c in range(cap + 1):
            dp[i][c] = dp[i - 1][c]  # 不选第i个物品
            if c >= weights[i - 1]:  # 容量足够选第i个物品
                dp[i][c] = max(dp[i][c], dp[i - 1][c - weights[i - 1]] + values[i - 1])
    return dp[n][cap]

# 测试
assert knapsack([2, 3, 4], [3, 4, 5], 5) == 7
print("Knapsack passed")
