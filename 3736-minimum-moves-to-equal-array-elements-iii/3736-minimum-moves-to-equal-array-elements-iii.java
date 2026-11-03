class Solution {
    public int minMoves(int[] nums) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++) max=Math.max(max,nums[i]);
        int ans=0;
        for(int num:nums) ans+=Math.abs(max-num);
        return ans;
    }
}