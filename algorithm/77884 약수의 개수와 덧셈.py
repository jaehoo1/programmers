def count_primes(num: int) -> int:
    count = 0
    for i in range(1, num + 1):
        if num % i == 0:
            count += 1
    return count

def solution(left: int, right: int) -> int:
    answer = 0
    for i in range(left, right + 1):
        answer += i if count_primes(i) % 2 == 0 else -i
    return answer