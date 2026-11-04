class Solution {
    public int countSquares(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        int[]dp=new int[n];
        int count=0;
        for(int i=0;i<m;i++){
            int diag=0;
            for(int j=0;j<n;j++){
                int temp = dp[j];
                if(matrix[i][j]==1){
                    if(j==0) dp[j]=1;
                    else    {             
                dp[j]=1+Math.min(dp[j],Math.min(dp[j-1],diag));
            }
            count+=dp[j];
                }
             else dp[j]=0;

            diag=temp;
        }
        }
        return count;
    }
    
}
