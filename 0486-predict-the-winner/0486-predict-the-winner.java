class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Base case: dp[i] = nums[i]
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }

        // Build solutions for larger subarrays
        for (int len = 2; len <= n; len++) {
            for (int i = n - len; i >= 0; i--) {
                int j = i + len - 1;

                dp[j] = Math.max(
                    nums[i] - dp[j],      // take left
                    nums[j] - dp[j - 1]   // take right
                );
            }
        }

        return dp[n - 1] >= 0;
    }
}