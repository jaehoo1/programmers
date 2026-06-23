def fits_in_wallet(wallet: list, bill: list) -> bool:
    if wallet[0] >= bill[0] and wallet[1] >= bill[1]:
        return True
    return wallet[0] >= bill[1] and wallet[1] >= bill[0]

def solution(wallet: list, bill: list) -> int:
    answer = 0
    while not fits_in_wallet(wallet, bill):
        bill[0 if bill[0] > bill[1] else 1] //= 2
        answer += 1
    return answer