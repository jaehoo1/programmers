NUMBERS = {
    "zero": "0",
    "one": "1",
    "two": "2",
    "three": "3",
    "four": "4",
    "five": "5",
    "six": "6",
    "seven": "7",
    "eight": "8",
    "nine": "9"
}

def solution(s: str) -> int:
    while any(k in s for k in NUMBERS):
        for k in NUMBERS:
            if s.find(k) != -1:
                s = s.replace(k, NUMBERS[k])
    return int(s)