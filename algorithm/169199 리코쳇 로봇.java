import java.util.LinkedList;
import java.util.Queue;

class Position {

    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position p) {
        this(p.x, p.y);
    }
}

class Solution {

    static final int[] DX = {-1, 0, 1, 0}, DY = {0, 1, 0, -1};

    static char[][] gameBoard;
    static int R, C;

    void initBoard(String[] board) {

        R = board.length;
        C = board[0].length();
        gameBoard = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                gameBoard[i][j] = board[i].charAt(j);
            }
        }
    }

    boolean canMove(Position dest) {

        return dest.x >= 0 && dest.x < R && dest.y >= 0 && dest.y < C && gameBoard[dest.x][dest.y] != 'D';
    }

    boolean canMove(Position robot, int vec) {

        return canMove(new Position(robot.x + DX[vec], robot.y + DY[vec]));
    }

    void move(Position robot, int vec) {

        robot.x += DX[vec];
        robot.y += DY[vec];
    }

    Position slide(Position robot, int vec) {

        while (canMove(robot, vec)) {
            move(robot, vec);
        }
        return robot;
    }

    Position findStartPosition() {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (gameBoard[i][j] == 'R') {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    int solution(String[] board) {

        initBoard(board);
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        Position start = findStartPosition();
        visited[start.x][start.y] = true;
        queue.offer(start);
        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Position cur = queue.poll();
                if (gameBoard[cur.x][cur.y] == 'G') {
                    return answer;
                }
                for (int i = 0; i < 4; i++) {
                    Position next = slide(new Position(cur), i);
                    if (visited[next.x][next.y]) {
                        continue;
                    }
                    visited[next.x][next.y] = true;
                    queue.offer(next);
                }
                size--;
            }
            answer++;
        }
        return -1;
    }
}