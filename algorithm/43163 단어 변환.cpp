# include <string>
# include <vector>
# include <queue>

using namespace std;

bool canchange(string &a, string &b) {
    int dif=0;
    for(int i=0 ; i<a.size() ; i++)
        if(a[i]!=b[i])
            dif++;
    if(dif<=1)
        return true;
    return false;
}
int solution(string begin, string target, vector<string> words) {
    int answer = 1;
    vector<int> G[50];
    for(int i=0 ; i<words.size()-1 ; i++)
        for(int j=i+1 ; j<words.size() ; j++)
            if(canchange(words[i], words[j])) {
                G[i].push_back(j);
                G[j].push_back(i);
            }
    int end=-1;
    for(int i=0 ; i<words.size() ; i++)
        if(target==words[i])
            end=i;
    if(end==-1)
        return 0;
    bool visited[50]={false, };
    queue<int> q;
    for(int i=0 ; i<words.size() ; i++)
        if(canchange(begin, words[i])) {
            visited[i]=true;
            q.push(i);
        }
    while(!q.empty()) {
        int size=q.size();
        while(size--) {
            int cur=q.front();
            q.pop();
            if(cur==end)
                return answer;
            for(int i=0 ; i<G[cur].size() ; i++)
                if(!visited[G[cur][i]]) {
                    visited[G[cur][i]]=true;
                    q.push(G[cur][i]);
                }
        }
        answer++;
    }
    return 0;
}
