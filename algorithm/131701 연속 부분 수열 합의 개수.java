import java.util.HashSet;
import java.util.Set;

class Solution {

    int sumOfCircularSequence(int[] elements, int startIdx, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += elements[startIdx++];
            if (startIdx == elements.length) {
                startIdx = 0;
            }
        }
        return sum;
    }

    int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for (int size = 1; size <= elements.length; size++) {
            for (int i = 0; i < elements.length; i++) {
                set.add(sumOfCircularSequence(elements, i, size));
            }
        }
        return set.size();
    }
}