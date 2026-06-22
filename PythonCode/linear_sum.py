# 求和
def solve(n):
    total = 0
    for i in range(1, n + 1):
        total += i
    return total

# 测试
assert solve(13) == 91
print("Solve sum passed")
