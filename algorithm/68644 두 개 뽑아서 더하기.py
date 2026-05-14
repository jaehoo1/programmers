def solution(numbers: list) -> list:
    answer = []
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            sum = numbers[i] + numbers[j]
            if sum not in answer:
                answer.append(sum)
    return sorted(answer)