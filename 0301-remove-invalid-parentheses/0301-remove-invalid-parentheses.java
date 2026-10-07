class Solution {

    Set<String> sb = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int removeLeft = 0;
        int removeRight = 0;

        // Find minimum number of '(' and ')' to remove
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                removeLeft++;
            } 
            else if (ch == ')') {

                if (removeLeft > 0) {
                    removeLeft--;
                } 
                else {
                    removeRight++;
                }
            }
        }

        dfs(0, 0, removeLeft, removeRight, "", s);

        return new ArrayList<>(sb);
    }

    private void dfs(int index, int bal,
                     int removeLeft, int removeRight,
                     String curr, String s) {

        // Entire string processed
        if (index == s.length()) {

            if (bal == 0 &&
                removeLeft == 0 &&
                removeRight == 0) {

                sb.add(curr);
            }

            return;
        }

        char ch = s.charAt(index);

        // ---------------- '(' ----------------
        if (ch == '(') {

            // REMOVE '('
            if (removeLeft > 0) {
                dfs(index + 1,
                    bal,
                    removeLeft - 1,
                    removeRight,
                    curr,
                    s);
            }

            // KEEP '('
            dfs(index + 1,
                bal + 1,
                removeLeft,
                removeRight,
                curr + '(',
                s);
        }

        // ---------------- ')' ----------------
        else if (ch == ')') {

            // REMOVE ')'
            if (removeRight > 0) {
                dfs(index + 1,
                    bal,
                    removeLeft,
                    removeRight - 1,
                    curr,
                    s);
            }

            // KEEP ')' only if there is '(' available
            if (bal > 0) {
                dfs(index + 1,
                    bal - 1,
                    removeLeft,
                    removeRight,
                    curr + ')',
                    s);
            }
        }

        // ---------------- Letter ----------------
        else {

            dfs(index + 1,
                bal,
                removeLeft,
                removeRight,
                curr + ch,
                s);
        }
    }
}