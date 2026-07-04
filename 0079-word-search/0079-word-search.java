class Solution {

    private boolean dfs(int i, int j, int index, char[][] board, String word) {

        if (index == word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;

        if (board[i][j] != word.charAt(index))
            return false;

        char temp = board[i][j];
        board[i][j] = '#';          // mark visited

        boolean found =
                dfs(i + 1, j, index + 1, board, word) ||
                dfs(i - 1, j, index + 1, board, word) ||
                dfs(i, j + 1, index + 1, board, word) ||
                dfs(i, j - 1, index + 1, board, word);

        board[i][j] = temp;         // restore (backtrack)

        return found;
    }

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        if(word.length()>n*m) return false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0, board, word))
                        return true;
                }

            }
        }

        return false;
    }
}