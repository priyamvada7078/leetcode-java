class Solution {

    private boolean isSafe(char[][] board, int row, int col, char digit) {

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit)
                return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit)
                return false;
        }

        // Check 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit)
                    return false;
            }
        }

        return true;
    }

    private boolean solve(char[][] board) {

        // Find the first empty cell
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    // Try digits 1 to 9
                    for (char digit = '1'; digit <= '9'; digit++) {

                        if (isSafe(board, i, j, digit)) {

                            // Choose
                            board[i][j] = digit;

                            // Explore
                            if (solve(board))
                                return true;

                            // Backtrack
                            board[i][j] = '.';
                        }
                    }

                    // No digit works
                    return false;
                }
            }
        }

        // No empty cell left
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}