import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<String> answer = new HashSet<>();

    boolean isValid(char[] parentheses) {
        int stack = 0;
        for (int i = 0; i < parentheses.length; i++) {
            char c = parentheses[i];
            if (c == '(') {
                stack++;
            } else if (c == ')') {
                if (stack <= 0) {
                    return false;
                }
                stack--;
            }
        }
        return stack == 0;
    }

    void recur(int depth, int n, char[] parentheses, int left, int right) {

        if (depth == n) {
            String s = new String(parentheses);
            if (!answer.contains(s) && isValid(parentheses)) {
                answer.add(s);
            }
            return;
        }

        if (left < n && left >= right) {
            parentheses[depth] = '(';
            recur(depth + 1, n, parentheses, left + 1, right);
        }
        if (right < n && right < left) {
            parentheses[depth] = ')';
            recur(depth + 1, n, parentheses, left, right + 1);
        }
    }

    public int solution(int n) {
        recur(0, n * 2, new char[n * 2], 0, 0);
        return answer.size();
    }
}