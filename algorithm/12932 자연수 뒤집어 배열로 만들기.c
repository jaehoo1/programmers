# include <stdio.h>
# include <stdlib.h>
# include <string.h>

void swap(int *a, int *b) {
    int temp=*a;
    *a=*b;
    *b=temp;
}
void reverse(int *arr, int len) {
    for(int i=0 ; i<len/2 ; i++)
        swap(&arr[i], &arr[len-i-1]);
}

int* solution(long long n) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    char str[12];
    sprintf(str, "%lld", n);
    int* answer = (int*)malloc(4*strlen(str));
    for(int i=0 ; str[i] ; i++)
        answer[i]=str[i]-'0';
    reverse(answer, strlen(str));
    return answer;
}
