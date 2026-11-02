class Solution {
    public int minMoves(int[] nums) {
        int min=nums[0];
        for(int i=0;i<nums.length;i++) min=Math.min(min,nums[i]);
        int ans=0;
        for(int num: nums) ans+=num-min;
        return ans;
    }
}