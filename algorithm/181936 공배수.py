def solution(number: int, n: int, m: int) -> int:
    if number % n == 0 and number % m == 0:
        return 1
    return 0