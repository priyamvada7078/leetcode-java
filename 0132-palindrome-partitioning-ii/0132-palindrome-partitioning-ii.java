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

    int[] dp = new int[n+1];

dp[n] = 0;

for(int i =n-1;i>=0;i--)
{
    int ans = Integer.MAX_VALUE;

    for(int j =i;j<n;j++)
    {
        if(pal[i][j])
        {
            ans = Math.min(ans, 1 + dp[j+1]);
        }
    }

    dp[i] = ans;
}

return dp[0]-1;
    }
}