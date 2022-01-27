# include <vector>
# include <queue>

using namespace std;

int bfs(vector<int> numbers, int target) {
    queue<int> q;
    q.push(0);
    for(int i=0 ; i<numbers.size() ; i++) {
        int size=q.size();
        while(size--) {
            int cur=q.front();
            q.pop();
            q.push(cur+numbers[i]);
            q.push(cur-numbers[i]);
        }
    }
    int answer=0;
    while(!q.empty()) {
        if(q.front()==target)
            answer++;
        q.pop();
    }
    return answer;
}
int solution(vector<int> numbers, int target) {
    return bfs(numbers, target);
}
