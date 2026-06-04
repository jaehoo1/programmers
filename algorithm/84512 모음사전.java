import java.util.ArrayList;
import java.util.List;

class Solution {

    static final String VOWELS = "AEIOU";
    static List<String> words = new ArrayList<>();

    void recur(char[] tree, int depth) {
        if (depth == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            tree[depth] = VOWELS.charAt(i);
            words.add(new String(tree, 0, depth + 1));
            recur(tree, depth + 1);
        }
    }

    int solution(String word) {
        recur(new char[5], 0);
        return words.indexOf(word) + 1;
    }
}