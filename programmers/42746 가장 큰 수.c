# include <stdio.h>
# include <string.h>
# include <stdlib.h>

typedef struct { char str[5]; }Str;

int Strcmp(const Str *a, const Str *b) {
	char A[13]={0, }, B[13]={0, };
	int alen=strlen(a->str), blen=strlen(b->str), i;
	for(i=0 ; i<12 ; i+=alen)
		strcpy(&A[i], a->str);
	for(i=0 ; i<12 ; i+=blen)
		strcpy(&B[i], b->str);
	for(i=0 ; i<12 ; i++)
		if(A[i]>B[i])
			return -1;
		else if(A[i]<B[i])
			return 1;
	return 0;
}

// numbers_len은 배열 numbers의 길이입니다.
char* solution(int numbers[], size_t numbers_len) {
    Str arr[100000], temp;
    for(int i=0 ; i<numbers_len ; i++) {
        sprintf(temp.str, "%d", numbers[i]);
        strcpy(arr[i].str, temp.str);
    }
    qsort(arr, numbers_len, sizeof(Str), (int(*)(const void*, const void*))Strcmp);
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(400001);
    int zero=1;
    for(int i=0 ; i<numbers_len ; i++) {
        strcpy(&answer[strlen(answer)], arr[i].str);
        if(zero&&strcmp("0", arr[i].str))
            zero=0;
    }
    if(zero)
        return "0";
    return answer;
}
