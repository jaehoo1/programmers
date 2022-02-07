# include <stdio.h>
# include <ctype.h>
# include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* s) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(strlen(s)*1);
    strcpy(answer, s);
    int idx=0;
    for(int i=0 ; s[i] ; i++)
        if(s[i]==' ') {
            idx=0;
            continue;
        } else {
            if(idx%2)
                answer[i]=tolower(s[i]);
            else
                answer[i]=toupper(s[i]);
            idx++;
        }
    return answer;
}
