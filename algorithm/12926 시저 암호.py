def solution(s: str, n: int) -> str:
    answer = ''
    for c in s:
        if c == ' ':
            answer += ' '
            continue
        encrypted = ord(c) + n
        if (c <= 'z' and encrypted > ord('z')) or (c <= 'Z' and encrypted > ord('Z')):
            encrypted -= 26
        answer += chr(encrypted)
    return answer