import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[y + 1];
        Queue<Integer> queue = new LinkedList<>();
        visited[x] = true;
        queue.offer(x);
        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == y) {
                    return answer;
                }
                if (cur + n <= y && !visited[cur + n]) {
                    visited[cur + n] = true;
                    queue.offer(cur + n);
                }
                if (cur * 2 <= y && !visited[cur * 2]) {
                    visited[cur * 2] = true;
                    queue.offer(cur * 2);
                }
                if (cur * 3 <= y && !visited[cur * 3]) {
                    visited[cur * 3] = true;
                    queue.offer(cur * 3);
                }
            }
            answer++;
        }
        return -1;
    }
}