import java.util.*;

class Solution {

    boolean[][] dp;

    public List<List<String>> partition(String s) {

        int n = s.length();
        dp = new boolean[n][n];

        // ----------------------------
        // STEP 1: DP PRECOMPUTATION
        // dp[i][j] = is s[i..j] palindrome?
        // ----------------------------

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        // ----------------------------
        // STEP 2: BACKTRACKING
        // ----------------------------

        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        solve(s, 0, curr, ans);

        return ans;
    }

    // backtracking using DP table
    private void solve(String s, int start,
                       List<String> curr,
                       List<List<String>> ans) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (dp[start][end]) {

                curr.add(s.substring(start, end + 1));

                solve(s, end + 1, curr, ans);

                curr.remove(curr.size() - 1);
            }
        }
    }
}