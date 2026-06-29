def solution(sizes: list):
    for size in sizes:
        if size[0] > size[1]:
            size[0], size[1] = size[1], size[0]
    return max(x[0] for x in sizes) * max(x[1] for x in sizes)