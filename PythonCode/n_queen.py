
def safe(cols, row, col):
    for (r,c) in enumerate(cols):
        if c==col or abs(row-r) == abs(col-c):
            return False
    return True

