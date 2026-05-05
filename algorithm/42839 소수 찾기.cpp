# include <string>
# include <vector>
# include <cstring>
# include <algorithm>

using namespace std;

vector<int> prime;
bool visited[7], flag[10000000];
char str[8], tree[8];
int len;

void dfs(int depth) {
    if(depth==len+1)
        return;
    tree[depth]=0;
    int num;
    sscanf(tree, "%d", &num);
    if(binary_search(prime.begin(), prime.end(), num))
        flag[num]=true;
    for(int i=0 ; i<len ; i++)
        if(!visited[i]) {
            visited[i]=true;
            tree[depth]=str[i];
            dfs(depth+1);
            visited[i]=false;
        }
}
int solution(string numbers) {
    prime.push_back(2);
    prime.push_back(3);
    for(int i=5 ; i<10000000 ; i+=2) {
        bool temp=false;
        for(int j=1 ; prime[j]*prime[j]<=i ; j++)
            if(i%prime[j]==0) {
                temp=true;
                break;
            }
        if(!temp)
            prime.push_back(i);
    }
    strcpy(str, numbers.c_str());
    len=strlen(str);
    dfs(0);
    int answer = 0;
    for(int i=0 ; i<10000000 ; i++)
        if(flag[i])
            answer++;
    return answer;
}
