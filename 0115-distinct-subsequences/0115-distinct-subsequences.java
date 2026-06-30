class Solution {
    public int numDistinct(String s1, String s2) {
        int mod = 1_000_000_007;
        int n = s1.length();
        int m = s2.length();

        long[] dp = new long[m + 1];

        // Base case: empty s2 can always be formed
        dp[0] = 1;

        // Process each character of s1
        for (int i = 0; i < n; i++) {

            // go right to left (VERY IMPORTANT)
            for (int j = m - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[j + 1] = (dp[j + 1] + dp[j]) % mod;
                }
            }
        }

        return (int) dp[m];
    }
}

