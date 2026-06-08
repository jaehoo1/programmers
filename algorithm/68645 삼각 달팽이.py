NX = [1, 0, -1]
NY = [0, 1, -1]

def solution(n: int) -> list:
    lists = []
    for i in range(1, n + 1):
        lists.append([0] * i)
    vector, x, y = 0, 0, 0
    for i in range(1, sum(range(1, n + 1)) + 1):
        lists[x][y] = i
        nextx = x + NX[vector]
        nexty = y + NY[vector]
        if nextx < 0 or nextx >= n or nexty < 0 or nexty >= n or lists[nextx][nexty]:
            vector += 1
            if vector >= 3:
                vector = 0
        x += NX[vector]
        y += NY[vector]
    return [x for row in lists for x in row]