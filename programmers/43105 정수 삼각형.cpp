# include <vector>

using namespace std;

int dp[501][501];

int dfs(int x, int y, vector<vector<int>> &triangle) {
    int case1=0, case2=0;
    if(!x&&!y)
        return triangle[0][0];
    if(dp[x][y]!=-1)
        return dp[x][y];
    if(y)
        case1=triangle[x][y]+dfs(x-1, y-1, triangle);
    if(y<x)
        case2=triangle[x][y]+dfs(x-1, y, triangle);
    return dp[x][y]=max(case1, case2);
}
int solution(vector<vector<int>> triangle) {
    for(int i=0 ; i<triangle.size() ; i++)
        for(int j=0 ; j<=i ; j++)
            dp[i][j]=-1;
    int answer = 0;
    for(int i=0 ; i<triangle.size() ; i++) {
        int temp=dfs(triangle.size()-1, i, triangle);
        if(temp>answer)
            answer=temp;
    }
    return answer;
}
