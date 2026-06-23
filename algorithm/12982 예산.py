def solution(d: list, budget: int) -> int:
    d.sort()
    sum = 0
    answer = 0
    for i in d:
        if sum + i <= budget:
            sum += i
            answer += 1
        else:
            break
    return answer