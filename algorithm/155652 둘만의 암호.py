def encode(c: str, skip: str, index: int) -> str:
    i = 0
    while i < index:
        c = chr(ord(c) + 1)
        if c > 'z':
            c = 'a'
        if c not in skip:
            i += 1
    return c

def solution(s: str, skip: str, index: int) -> str:
    answer = ''
    for c in s:
        answer += encode(c, skip, index)
    return answer