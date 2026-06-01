import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Friends4Block {

    static final int[] NX = {0, 1, 1}, NY = {1, 0, 1};
    char[][] board;
    int R, C;

    public Friends4Block(String[] board) {
        this.R = board.length;
        this.C = board[0].length();
        this.board = new char[R][C];
        for (int i = 0; i < R; i++) {
            this.board[i] = board[i].toCharArray();
        }
    }

    Set<Position> getRemovablePositions() {
        Set<Position> positions = new HashSet<>();
        for (int i = 0; i < R - 1; i++) {
            for (int j = 0; j < C - 1; j++) {
                char cur = board[i][j];
                if (cur == ' ') {
                    continue;
                }
                boolean isSame = true;
                for (int k = 0; k < 3; k++) {
                    int nextx = i + NX[k];
                    int nexty = j + NY[k];
                    if (cur != board[nextx][nexty]) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    positions.add(new Position(i, j));
                    for (int k = 0; k < 3; k++) {
                        positions.add(new Position(i + NX[k], j + NY[k]));
                    }
                }
            }
        }
        return positions;
    }

    void removeBlocks(Set<Position> removablePositions) {
        removablePositions.forEach(p -> board[p.x][p.y] = ' ');
    }

    void gravity() {
        for (int i = R - 1; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != ' ') {
                    continue;
                }
                int k = i - 1;
                while (k >= 0 && board[k][j] == ' ') {
                    k--;
                }
                if (k < 0) {
                    continue;
                }
                char temp = board[i][j];
                board[i][j] = board[k][j];
                board[k][j] = temp;
            }
        }
    }

    int gameResult() {
        int score = 0;
        while (true) {
            Set<Position> removablePositions = getRemovablePositions();
            if (removablePositions.isEmpty()) {
                break;
            }
            score += removablePositions.size();
            removeBlocks(removablePositions);
            gravity();
        }
        return score;
    }
}

class Solution {

    int solution(int m, int n, String[] board) {
        return new Friends4Block(board).gameResult();
    }
}