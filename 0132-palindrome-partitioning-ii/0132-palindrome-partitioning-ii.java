import java.util.*;

class Solution {

    public int minCut(String s) {

        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        // STEP 1: palindrome DP
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    if (j - i <= 2) {
                        pal[i][j] = true;
                    } else {
                        pal[i][j] = pal[i + 1][j - 1];
                    }
                }
            }
        }

        // STEP 2: min cut DP
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {

            // worst case: cut before every char
            dp[i] = i;

            for (int j = 0; j <= i; j++) {

                if (pal[j][i]) {

                    if (j == 0) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
}