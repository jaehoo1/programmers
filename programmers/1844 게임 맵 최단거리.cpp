# include <vector>
# include <queue>

using namespace std;

int solution(vector<vector<int> > maps) {
    int answer = 1, dx[]={-1, 0, 1, 0}, dy[]={0, 1, 0, -1}, n=maps.size(), m=maps[0].size();
    bool visited[100][100]={false, };
    queue<pair<int, int>> q;
    visited[0][0]=true;
    q.push({0, 0});
    while(!q.empty()) {
        int size=q.size();
        while(size--) {
            int curx=q.front().first;
            int cury=q.front().second;
            q.pop();
            if(curx==n-1&&cury==m-1)
                return answer;
            for(int i=0 ; i<4 ; i++) {
                int nx=curx+dx[i];
                int ny=cury+dy[i];
                if(nx<0||nx>=n||ny<0||ny>=m)
                    continue;
                if(visited[nx][ny]||!maps[nx][ny])
                    continue;
                visited[nx][ny]=true;
                q.push({nx, ny});
            }
        }
        answer++;
    }
    return -1;
}
