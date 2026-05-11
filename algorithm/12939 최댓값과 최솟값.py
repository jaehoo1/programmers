def solution(s: str) -> str:
    lt = list(map(int, s.split()))
    return f"{min(lt)} {max(lt)}"