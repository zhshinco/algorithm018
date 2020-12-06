public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<char[]> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            board.add(chars);
        }
        backtracking(n, 0, board, result);
        return result;
    }

    private void backtracking(int n, int row, List<char[]> board, List<List<String>> result) {
        if(n == row){
            List<String> path = new ArrayList<>();
            for (char[] chars : board) {
                path.add(new String(chars));
            }
            result.add(path);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, board)) {
                board.get(row)[col] = 'Q';
                backtracking(n, row + 1, board, result);
                board.get(row)[col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, List<char[]> board) {

        //横
        for (int i = 0; i < row; i++) {
            if (board.get(i)[col] == 'Q') {
                return false;
            }
        }

        //竖
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i)[j] == 'Q') {
                return false;
            }
        }

        //斜
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i)[j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
