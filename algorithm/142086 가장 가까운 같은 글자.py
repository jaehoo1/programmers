def solution(s: str) -> list:
    answer = []
    dp = [-1] * 26
    for i in range(len(s)):
        chr_idx = ord(s[i]) - 97
        answer.append(-1 if dp[chr_idx] == -1 else i - dp[chr_idx])
        dp[chr_idx] = i
    return answer