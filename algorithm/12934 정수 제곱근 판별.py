import math

def solution(n: int) -> int:
    sqrt = int(math.sqrt(n))
    if sqrt ** 2 == n:
        return (sqrt + 1) ** 2
    return -1