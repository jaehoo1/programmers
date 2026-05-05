def tostring(dec, n):
    string = ""
    for _ in range(n):
        if dec % 2 == 1:
            string += '#'
        else:
            string += ' '
        dec //= 2
    return string[::-1]

def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        answer.append(tostring(arr1[i]|arr2[i], n))
    return answer
