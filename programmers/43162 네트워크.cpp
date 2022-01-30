#include <vector>

using namespace std;

vector<int> G[201];
bool visited[201];

void dfs(int n) {
    visited[n]=true;
    for(int i=0 ; i<G[n].size() ; i++)
        if(!visited[G[n][i]])
            dfs(G[n][i]);
}
int solution(int n, vector<vector<int>> computers) {
    for(int i=0 ; i<n ; i++)
        for(int j=0 ; j<n ; j++)
            if(i==j)
                continue;
            else if(computers[i][j])
                G[i+1].push_back(j+1);
    int answer = 0;
    for(int i=1 ; i<=n ; i++)
        if(!visited[i]) {
            answer++;
            dfs(i);
        }
    return answer;
}
