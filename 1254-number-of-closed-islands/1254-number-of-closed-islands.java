class Solution {
    public boolean countIslands(int i, int j, int[][] grid) {
            if(i < 0 || j < 0 || i == grid.length || j == grid[0].length) {
        return false;
    }
    if(grid[i][j] == 1) {
        return true;
    }
    grid[i][j] = 1;
    boolean a = countIslands(i+1, j, grid) ;
    boolean b = countIslands(i-1, j, grid) ;
    boolean c = countIslands(i, j+1, grid) ;
    boolean d = countIslands(i, j-1, grid);
    return a && b && c && d;
}
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int islands=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) {
                    if(countIslands(i,j,grid)) islands++;
            }
        }
        }
        return islands;
    }
}