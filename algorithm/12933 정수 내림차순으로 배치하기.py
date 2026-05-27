def solution(n: int) -> int:
    return int(''.join(sorted(str(n), reverse=True)))