# n皇后问题 (回溯法)
def safe(cols, row, col):
    # cols 记录了之前每一行皇后所在的列
    for r, c in enumerate(cols):
        if c == col or abs(row - r) == abs(col - c):
            return False
    return True

def solve_n_queens(n):
    ans = []
    def backtrack(row, cols):
        if row == n:
            ans.append(cols[:])
            return
        for col in range(n):
            if safe(cols, row, col):
                cols.append(col)
                backtrack(row + 1, cols)
                cols.pop()  # 回溯
    backtrack(0, [])
    return ans

# 测试
solutions = solve_n_queens(4)
assert len(solutions) == 2  # 4皇后有2个解
print(f"N-Queens passed. Solutions for 4-Queens: {solutions}")
