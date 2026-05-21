import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

class Position {

    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    static final int[] NX = {-1, 0, 1, 0}, NY = {0, 1, 0, -1};
    static int R, C;

    int floodFill(int[][] foods, Position start) {
        Queue<Position> queue = new LinkedList<>();
        int food = foods[start.x][start.y];
        foods[start.x][start.y] = 0;
        queue.offer(start);
        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            food += foods[cur.x][cur.y];
            for (int i = 0; i < 4; i++) {
                int nextx = cur.x + NX[i];
                int nexty = cur.y + NY[i];
                if (nextx < 0 || nextx >= R || nexty < 0 || nexty >= C || foods[nextx][nexty] == 0) {
                    continue;
                }
                food += foods[nextx][nexty];
                foods[nextx][nexty] = 0;
                queue.offer(new Position(nextx, nexty));
            }
        }
        return food;
    }

    int[] solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        int[][] foods = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                foods[i][j] = maps[i].charAt(j) == 'X' ? 0 : maps[i].charAt(j) - '0';
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (foods[i][j] > 0) {
                    answer.add(floodFill(foods, new Position(i, j)));
                }
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        answer.sort(Integer::compareTo);
        int[] arr = new int[answer.size()];
        IntStream.range(0, answer.size())
                .forEach(i -> arr[i] = answer.get(i));
        return arr;
    }
}