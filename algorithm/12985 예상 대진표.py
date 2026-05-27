def solution(n: int, a: int, b: int) -> int:
    a -= 1
    b -= 1
    answer = 0
    while a != b:
        a //= 2
        b //= 2
        answer += 1
    return answer