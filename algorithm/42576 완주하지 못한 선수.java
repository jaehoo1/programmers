import java.util.HashMap;
import java.util.Map;

class Solution {
    
    String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.compute(s, (k, v) -> v == null ? 1 : v + 1);
        }
        for (String s : completion) {
            map.computeIfPresent(s, (k, v) -> v == 1 ? null : v - 1);
        }
        return map.keySet().stream().findAny().get();
    }
}