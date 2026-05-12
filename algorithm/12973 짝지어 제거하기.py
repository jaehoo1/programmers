def solution(s: str) -> int:
    lt = []
    for c in s:
        if lt and c == lt[-1]:
            del lt[-1]
        else:
            lt.append(c)
    return 1 if len(lt) == 0 else 0