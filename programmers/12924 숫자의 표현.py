def solution(n: int) -> int:
    answer = 0
    i = 1
    j = 2
    while i <= n:
        range_sum = sum(range(i, j))
        if range_sum == n:
            answer += 1
        if range_sum <= n:
            j += 1
        else:
            i += 1
    return answer