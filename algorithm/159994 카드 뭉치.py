def solution(cards1: list, cards2: list, goal: list) -> bool:
    while goal:
        if cards1 and cards1[0] == goal[0]:
            del cards1[0]
            del goal[0]
        elif cards2 and cards2[0] == goal[0]:
            del cards2[0]
            del goal[0]
        else:
            break
    return "No" if goal else "Yes"