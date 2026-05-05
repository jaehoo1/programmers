# include <stdio.h>
# include <stdbool.h>

bool solution(int x) {
    char str[6];
    sprintf(str, "%d", x);
    int mod=0;
    for(int i=0 ; str[i] ; i++)
        mod+=str[i]-'0';
    return x%mod?false:true;
}
