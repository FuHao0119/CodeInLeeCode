# 求最长公共子序列长度
def lcs(x,y): 
    m,n = len(x),len(y)
    dp = [[0]*(n+1) for _ in range(m+1)]
    for i in range(1,m+1):
        for j in range(1,n+1):
            if(x[i-1] == y[j-1]):  # 当x的第i个字符和y的第j个相等时
                dp[i][j] = dp[i-1][j-1] + 1 
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])

    return dp[m][n]
