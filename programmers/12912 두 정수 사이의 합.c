# include <stdio.h>

void swap(int *a, int *b) {
    int temp=*a;
    *a=*b;
    *b=temp;
}

long long solution(int a, int b) {
    if(a>b)
        swap(&a, &b);
    long long answer = 0;
    for( ; a<=b ; a++)
        answer+=a;
    return answer;
}
