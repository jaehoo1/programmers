import java.util.Arrays;

class Solution {

    static int answer;

    void recur(int[] tree, int[] number,  int depth, int index) {

        if (depth == 3) {
            if (Arrays.stream(tree).sum() == 0) {
                answer++;
            }
            return;
        }

        for (int i = index; i < number.length; i++) {
            tree[depth] = number[i];
            recur(tree, number, depth + 1, i + 1);
        }
    }

    int solution(int[] number) {

        recur(new int[3], number, 0, 0);
        return answer;
    }
}