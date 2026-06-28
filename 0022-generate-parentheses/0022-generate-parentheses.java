class Solution {

    public boolean isValid(String s) {
        int balance = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(')
                balance++;
            else
                balance--;

            if (balance < 0)
                return false;
        }

        return balance == 0;
    }

    public void generateAll(String curr, int len, List<String> ans) {

        if (curr.length() == len) {
            if (isValid(curr))
                ans.add(curr);
            return;
        }

        generateAll(curr + "(", len, ans);
        generateAll(curr + ")", len, ans);
    }

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        generateAll("", 2 * n, ans);

        return ans;
    }
}