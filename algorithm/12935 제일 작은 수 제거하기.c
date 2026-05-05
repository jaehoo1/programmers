# include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int min=arr[0];
    for(int i=1 ; i<arr.size() ; i++)
        if(arr[i]<min)
            min=arr[i];
    for(int i=0 ; i<arr.size() ; i++)
        if(arr[i]!=min)
            answer.push_back(arr[i]);
    if(!answer.size())
        answer.push_back(-1);
    return answer;
}
