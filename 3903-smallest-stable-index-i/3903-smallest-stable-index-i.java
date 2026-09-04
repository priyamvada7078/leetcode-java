class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int max=0;
        int index=-1;
        int min;    
        for(int i=0;i<n;i++){
           max=Math.max(max,nums[i]);
           min=nums[i];
           for(int j=i+1;j<n;j++) min=Math.min(min,nums[j]);
           if((max-min)<=k) {
            index=i;
            break;
           }
        }
        return index;
    }
}