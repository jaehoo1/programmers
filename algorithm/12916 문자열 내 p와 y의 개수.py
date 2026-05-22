def solution(s: str) -> bool:
    return s.count('p') + s.count('P') == s.count('y') + s.count('Y')