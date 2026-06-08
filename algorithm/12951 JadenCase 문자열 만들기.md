# [12951 : JadenCase 문자열 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12951)
https://school.programmers.co.kr/learn/courses/30/lessons/12951

## 아이디어
String, Implementation

Python의 `str.title()` 을 이용하면 구현이 단순해질 것 같아 사용해 구현해봤다.
```python
def solution(s: str) -> str:
    answer = ''
    s = s.title()
    for i in range(1, len(s)):
        # 앞글자가 숫자면 뒤에는 무조건 소문자가 되야함(str.title() 에서는 대문자로 처리됨)
        if s[i - 1] >= '0' and s[i - 1] <= '9':
            answer += s[i].lower()
        else:
            answer += s[i]
    return s[0] + answer
```