class Solution {
    private boolean dfs(int i,int j,int index,char[][] board,String word,boolean[][] vis){
        if(index==word.length()) return true;
        if(i<0 || j<0 ||i>=board.length || j>=board[0].length) return false;
        if(vis[i][j]==true) return false;
        if(board[i][j]!=word.charAt(index)) return false;
        vis[i][j]=true;
        boolean down=dfs(i+1,j,index+1,board,word,vis);
        boolean up=dfs(i-1,j,index+1,board,word,vis);
        boolean right=dfs(i,j+1,index+1,board,word,vis);
        boolean left=dfs(i,j-1,index+1,board,word,vis);
        if(down || up || right|| left){
        vis[i][j]=false;
        return true;
        }
        vis[i][j]=false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(i,j,0,board,word,vis)) return true;
                }
            }
        }
return false;
    }
}