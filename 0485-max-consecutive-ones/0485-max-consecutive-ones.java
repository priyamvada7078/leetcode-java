class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==1){
            if(nums[0]==0) return 0;
            else return 1;
                    }
        int count=0;
        int max=0;
        int i=0;
        while(i<nums.length){
            if(nums[i]==1){
                count++;
                max=Math.max(count,max);
            }
            if(nums[i]==0) count=0;
            i++;
        }
        return max;
    }
}