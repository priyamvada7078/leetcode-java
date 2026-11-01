class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[] dp = new int[n];

        // Copy last row into dp
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        // Traverse from second-last row to first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {

                dp[j] = triangle.get(i).get(j)
                     + Math.min(dp[j], dp[j + 1]);

            }
        }

        return dp[0];
    }
}