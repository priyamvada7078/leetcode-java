

class Solution {

    public void backtrack(List<String> ans, String current,
                          int open, int close, int n) {

        // Base Case
        if (current.length() == 2 * n) {
            ans.add(current);
            return;
        }

        // Add '(' if available
        if (open < n) {
            backtrack(ans, current + "(", open + 1, close, n);
        }

        // Add ')' only if it won't make the string invalid
        if (close < open) {
            backtrack(ans, current + ")", open, close + 1, n);
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        backtrack(ans, "", 0, 0, n);

        return ans;
    }
}