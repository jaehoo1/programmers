# include <vector>
# include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i=0 ; i<scoville.size() ; i++)
        pq.push(scoville[i]);
    int answer = 0;
    while(pq.size()>1) {
        int first=pq.top();
        if(first>=K)
            break;
        pq.pop();
        int second=pq.top();
        pq.pop();
        pq.push(first+second*2);
        answer++;
    }
    return pq.top()>=K?answer:-1;
}
