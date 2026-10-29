class Solution {
    private int solve(int i,int j,int[][] a,int[][] dp){
        if(i==0 && j==0) return a[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=solve(i-1,j,a,dp);
        int left=solve(i,j-1,a,dp);
        if(up!=Integer.MAX_VALUE) up+=a[i][j];
        if(left!=Integer.MAX_VALUE) left+=a[i][j];
        return dp[i][j]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);


        int sum=solve(m-1,n-1,grid,dp);
        return sum;
    }
}