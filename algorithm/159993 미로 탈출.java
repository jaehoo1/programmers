import java.util.LinkedList;
import java.util.Queue;

class Position {

    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
}

class Solution {

    static final int[] NX = {-1, 0, 1, 0}, NY = {0, 1, 0, -1};
    static int R, C;

    int bfs(String[] maps, Position start, Position end) {
        boolean[][] visited = new boolean[R][C];
        Queue<Position> queue = new LinkedList<>();
        visited[start.x][start.y] = true;
        queue.offer(start);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position cur = queue.poll();
                if (cur.equals(end)) {
                    return depth;
                }
                for (int k = 0; k < 4; k++) {
                    int nextx = cur.x + NX[k];
                    int nexty = cur.y + NY[k];
                    if (nextx < 0 || nextx >= R || nexty < 0 || nexty >= C || visited[nextx][nexty] || maps[nextx].charAt(nexty) == 'X') {
                        continue;
                    }
                    visited[nextx][nexty] = true;
                    queue.offer(new Position(nextx, nexty));
                }
            }
            depth++;
        }
        return -1;
    }

    Position find(String[] maps, char c) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maps[i].charAt(j) == c) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        Position S = find(maps, 'S');
        Position L = find(maps, 'L');
        Position E = find(maps, 'E');
        int phase1 = bfs(maps, S, L);
        int phase2 = bfs(maps, L, E);
        return phase1 == -1 || phase2 == -1 ? -1 : phase1 + phase2;
    }
}