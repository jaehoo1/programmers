from datetime import date

def solution(a: int, b: int) -> str:
    return ["MON","TUE","WED","THU","FRI","SAT","SUN"][date(2016, a, b).weekday()]