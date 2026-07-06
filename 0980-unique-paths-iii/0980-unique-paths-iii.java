class Solution {
    private int helper(int i, int j, boolean[][] vis,int[][] grid, int remaining,int m,int n) {
       
       if (i < 0 || j < 0 || i >= m || j >= n)
            return 0;

        if (grid[i][j] == -1)
            return 0;

        if (vis[i][j])
            return 0;

        if (grid[i][j] == 2) {
            if (remaining == 1)
                return 1;

            return 0;
        }
        remaining--;
        vis[i][j] = true;
        int count=0;

        count+=helper(i + 1, j,vis, grid,remaining,m,n);
        count+=helper(i, j - 1,vis, grid,remaining,m,n);
        count+=helper(i, j + 1,vis, grid,remaining,m,n);
        count+=helper(i - 1, j,vis, grid, remaining,m,n);

        vis[i][j] = false;
        return count;
    }

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int startRow = 0;
        int startCol = 0;
        int remaining = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
                if (grid[i][j] != -1)
                    remaining++;
            }
        }
        boolean[][] vis = new boolean[m][n];
        int count = helper(startRow, startCol, vis, grid, remaining, m, n);
        return count;
    }
}