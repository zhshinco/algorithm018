public class SurroundRegion {

    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) return;
        int col = board[0].length;
        int dummy = row * col;
        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        UF uf = new UF(dummy);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        uf.union(i * col + j, dummy);
                    } else {
                        for (int k = 0; k < 4; k++) {
                            int x = i + d[k][0];
                            int y = j + d[k][1];
                            if (board[x][y] == 'O') uf.union(x * col + y, i * col + j);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (!uf.connected(i * col + j, dummy)) board[i][j] = 'X';
            }
        }
    }
}