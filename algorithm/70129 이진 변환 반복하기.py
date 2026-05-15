def solution(s: str) -> list:
    count_loop = 0
    count_zero = 0
    while s != "1":
        count_loop += 1
        count_zero += s.count('0')
        s = bin(len(s.replace('0', '')))[2:]
    return [count_loop, count_zero]