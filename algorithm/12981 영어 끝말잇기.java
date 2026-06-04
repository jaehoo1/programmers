import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    boolean isValid(String[] words, int index) {
        if (index == 0) {
            return true;
        }
        Set<String> preWords = Arrays.stream(words, 0, index)
                .collect(Collectors.toSet());
        if (preWords.contains(words[index])) {
            return false;
        }
        return words[index - 1].charAt(words[index - 1].length() - 1) == words[index].charAt(0);
    }

    int[] solution(int n, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!isValid(words, i)) {
                return new int[]{i % n + 1, i / n + 1};
            }
        }
        return new int[]{0, 0};
    }
}