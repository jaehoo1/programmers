int solution(int num) {
    int answer = 0;
    long long ll=num;
    for( ; answer<500 ; answer++)
        if(ll==1)
            break;
        else if(ll%2)
            ll=ll*3+1;
        else
            ll/=2;
    return ll==1?answer:-1;
}
