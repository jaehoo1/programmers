def solution(price: int, money: int, count: int) -> int:
    money -= sum([price * i for i in range(1, count + 1)])
    return 0 if money > 0 else -money