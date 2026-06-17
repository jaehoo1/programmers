import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    int[] solution(String[] name, int[] yearning, String[][] photo) {

        Map<String, Integer> map = IntStream.range(0, name.length)
                .mapToObj(i -> Map.entry(name[i], yearning[i]))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return Arrays.stream(photo)
                .mapToInt(strings ->
                        Arrays.stream(strings)
                                .mapToInt(s -> map.getOrDefault(s, 0)).sum()
                )
                .toArray();
    }
}