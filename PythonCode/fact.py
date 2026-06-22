# 阶乘递归
def fact(n):
    if n <= 1:
        return 1
    return n * fact(n - 1)

# 测试
assert fact(8) == 40320
print("Fact passed")
