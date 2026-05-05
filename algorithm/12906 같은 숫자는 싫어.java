import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                continue;
            }
            queue.add(arr[i]);
        }

        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }
        return answer;
    }
}