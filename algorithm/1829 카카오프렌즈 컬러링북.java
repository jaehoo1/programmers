import java.util.LinkedList;
import java.util.Queue;

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

    int bfs(int[][] picture, Position start) {
        Queue<Position> queue = new LinkedList<>();
        int color = picture[start.x][start.y];
        picture[start.x][start.y] = 0;
        queue.offer(start);
        int size = 0;
        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            size++;
            picture[cur.x][cur.y] = 0;
            for (int i = 0; i < 4; i++) {
                int nextx = cur.x + NX[i];
                int nexty = cur.y + NY[i];
                if (nextx < 0 || nextx >= R || nexty < 0 || nexty >= C || picture[nextx][nexty] != color) {
                    continue;
                }
                picture[nextx][nexty] = 0;
                queue.offer(new Position(nextx, nexty));
            }
        }
        return size;
    }

    int[] solution(int m, int n, int[][] picture) {
        R = m;
        C = n;

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (picture[i][j] != 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(picture, new Position(i, j)));
                }
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}