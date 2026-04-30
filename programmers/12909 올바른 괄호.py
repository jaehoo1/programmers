def solution(s: str) -> bool:
    stack = 0
    for c in s:
        if c == '(':
            stack += 1
        elif c == ')':
            if stack <= 0:
                return False
            else:
                stack -= 1
    return stack == 0