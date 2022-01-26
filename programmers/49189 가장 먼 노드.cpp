# include <vector>
# include <queue>
# define    INF 1e9

using namespace std;

vector<int> G[20001];
int D[20002];

void dijkstra(int start) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    D[start]=0;
    pq.push({0, start});
    while(!pq.empty()) {
        int dist=pq.top().first;
        int cur=pq.top().second;
        pq.pop();
        if(D[cur]<dist)
            continue;
        for(int i=0 ; i<G[cur].size() ; i++) {
            int next=G[cur][i];
            int cost=dist+1;
            if(cost<D[next]) {
                D[next]=cost;
                pq.push({cost, next});
            }
        }
    }
}
int solution(int n, vector<vector<int>> edge) {
    fill(D, D+n+1, INF);
    for(int i=0 ; i<edge.size() ; i++) {
        G[edge[i][0]].push_back(edge[i][1]);
        G[edge[i][1]].push_back(edge[i][0]);
    }
    dijkstra(1);
    int answer = 0, farthest=0;
    for(int i=1 ; i<=n ; i++)
        if(D[i]>farthest)
            farthest=D[i];
    for(int i=1 ; i<=n ; i++)
        if(D[i]==farthest)
            answer++;
    return answer;
}
