def solution(n: int, m: int, section: list) -> int:
    answer = 0
    painted = [True] * (n + 1)
    for i in section:
        painted[i] = False
    for i in section:
        if painted[i]:
            continue
        answer += 1
        for j in range(i, min(i + m, n + 1)):
            painted[j] = True
    return answer