import java.util.*;
import java.util.stream.Collectors;

class Solution {

    int solution(int[] topping) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = Arrays.stream(topping).boxed().collect(Collectors.toSet());
        Map<Integer, Integer> maxIndex = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            maxIndex.put(topping[i], i);
        }
        int answer = 0;
        for (int i = 0; i < topping.length; i++) {
            setA.add(topping[i]);
            if (maxIndex.get(topping[i]) == i) {
                setB.remove(topping[i]);
            }
            if (setA.size() == setB.size()) {
                answer++;
            }
        }
        return answer;
    }
}