def lcs(x, y):
    n = len(x)
    m = len(y)
    # 你提交的代码逻辑
    dp = [[0]*(n+1) for _ in range(m+1)]
    for i in range(1,n+1):
        for j in range(1, n+1): # 这里的循环边界和 dp 定义需要注意
            if x[i-1] == y[j-1]: dp[i][j] = dp[i-1][j-1] + 1
            else: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
            
    return dp[n][m]

if __name__ == "__main__":
    try:
        res = lcs("ABC", "AC")
        print(f"Result: {res}")
    except Exception as e:
        print(f"Error: {e}")
