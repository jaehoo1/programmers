# include <stdio.h>
# include <string.h>
# include <stdbool.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
bool solution(const char* s) {
    for(int i=0 ; i<s[i] ; i++)
        if(s[i]<'0'||s[i]>'9')
            return false;
    int len=strlen(s);
    if(len!=4&&len!=6)
        return false;
    return true;
}
