#include <vector>

using namespace std;

int submit(int person, int idx) {
    if(person==1)
        return idx%5+1;
    if(person==2) {
        int arr[]={2, 1, 2, 3, 2, 4, 2, 5};
        return arr[idx%8];
    }
    if(person==3) {
        int arr[]={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        return arr[idx%10];
    }
}

vector<int> solution(vector<int> answers) {
    int a=0, b=0, c=0;
    for(int i=0 ; i<answers.size() ; i++) {
        if(submit(1, i)==answers[i])
            a++;
        if(submit(2, i)==answers[i])
            b++;
        if(submit(3, i)==answers[i])
            c++;
    }
    vector<int> answer;
    if(a>=b&&a>=c)
        answer.push_back(1);
    if(b>=a&&b>=c)
        answer.push_back(2);
    if(c>=a&&c>=b)
        answer.push_back(3);
    return answer;
}
