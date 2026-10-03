class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];

            // Start a new subarray containing only num
            next[num % k]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                int newRemainder = (int) ((long) r * num % k);
                next[newRemainder] += dp[r];
            }

            // Add counts to the final result
            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            dp = next;
        }

        return result;
    }
}