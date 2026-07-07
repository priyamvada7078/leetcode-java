class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0;
        int ans = 0;
        
        while (right < nums.length) {
            if (nums[right] == 0) {
                // Sequence of 1s broken, calculate length
                ans = Math.max(ans, right - left);
                
                // Skip all consecutive 0s
                while (right < nums.length && nums[right] == 0) {
                    right++;
                }
                // Start next streak from current right
                left = right;
            } else {
                right++;
            }
        }
        // Catch the last sequence if the array ends with 1s
        return Math.max(ans, right - left);
    }
}