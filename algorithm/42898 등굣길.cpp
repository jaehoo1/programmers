# include <vector>

using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    long long dp[100][100]={1, };
    bool water[100][100]={false, };
    for(int i=0 ; i<puddles.size() ; i++)
        water[puddles[i][1]-1][puddles[i][0]-1]=true;
    for(int i=0 ; i<n ; i++)
        for(int j=0 ; j<m ; j++)
            if((!i&&!j)||water[i][j])
                continue;
            else if(!i)
                dp[i][j]=dp[i][j-1];
            else if(!j)
                dp[i][j]=dp[i-1][j];
            else
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000007;
    return dp[n-1][m-1];
}
