import math

def solution(n: int, m: int) -> list:
    return [math.gcd(n, m), math.lcm(n, m)]