class Position {

    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    static final int[] DX = {-1, 0, 1, 0}, DY = {0, 1, 0, -1};

    int solution(String[][] board, int h, int w) {
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            int nextx = h + DX[i];
            int nexty = w + DY[i];
            if (nextx < 0 || nextx >= board.length || nexty < 0 || nexty >= board[0].length || !board[h][w].equals(board[nextx][nexty])) {
                continue;
            }
            answer++;
        }
        return answer;
    }
}