def solution(s: str) -> str:
    answer = ''
    s = s.title()
    for i in range(1, len(s)):
        if s[i - 1] >= '0' and s[i - 1] <= '9':
            answer += s[i].lower()
        else:
            answer += s[i]
    return s[0] + answer