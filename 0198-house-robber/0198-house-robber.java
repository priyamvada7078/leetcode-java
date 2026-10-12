class Solution {
    public static int solve(int id,int[] nums,int[] dp){
        if(id==0) return nums[id];
        if(id<0) return 0;
        if(dp[id]!=-1) return dp[id];
        int pik=nums[id]+solve(id-2,nums,dp);
        int notpik=0+solve(id-1,nums,dp);
        return dp[id]=Math.max(pik,notpik);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,nums,dp);
    }
}