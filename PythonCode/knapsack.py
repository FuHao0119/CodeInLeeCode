# 01背包问题
def knapsack(weight, values, cap):
    # weight是一个数组 存放所有物品的重量 values是个数组 存放所有物品的价值 cap为最大承重
    n = len(weight)
    dp = [[0]*(cap+1) for i in range(n+1)]
    # 定义dp[i][c] 当背包容量为c的时候，只考虑前i个物品，所能选到的最大价值
    for i in range(n+1):
        for c in range(cap+1)：
            current_weight = weight[i-1] # 当前物品的重量
            current_value  = values[i-1] # 当前物品的价值
            dp[i][c] = dp[i-1][c] 
            if current_weight >= c:  # 当我当前背包的容量大于当前物品的重量的时候考虑选或者不选
                dp[i][c] = max(dp[i][c], dp[i-1][c - current_weight] + current_value)

    return dp[n][cap]

