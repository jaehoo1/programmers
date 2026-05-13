def solution(arr: list, divisor: int) -> list:
    return sorted([x for x in arr if x % divisor == 0]) or [-1]