def solution(a: int, b: int, n: int) -> int:
    answer = 0
    while n >= a:
        bottle = n // a * b
        answer += bottle
        n %= a
        n += bottle
    return answer