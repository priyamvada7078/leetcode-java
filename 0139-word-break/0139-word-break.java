class Solution {
    private boolean solve(int index, String s, Boolean[] dp,HashSet<String> set) {
        if (index == s.length())
            return true;
        if (dp[index] != null)
            return dp[index];
        String word = "";
        // HashSet<String> set = new HashSet<>(dictionary);
        for (int end = index; end < s.length(); end++) {
            word = s.substring(index, end + 1);

            if (set.contains(word)) {

                if (solve(end + 1, s, dp,set)){
                    dp[index] = true;
                return true;
            }
            }
        }
        dp[index] = false;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
         HashSet<String> set = new HashSet<>(wordDict);
        if (solve(0, s, dp,set))
            return true;
        return false;
    }
}