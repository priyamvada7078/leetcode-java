class Solution {

    List<String> ans = new ArrayList<>();

    private void helper(String num, int target, int index,
                        StringBuilder expr,
                        long value,
                        long prev) {

        // Base Case
        if (index == num.length()) {
            if (value == target) {
                ans.add(expr.toString());
            }
            return;
        }

        // Remember expression length for backtracking
        int len = expr.length();

        // Build the current operand
        for (int end = index; end < num.length(); end++) {

            // Skip numbers with leading zero
            if (end > index && num.charAt(index) == '0')
                break;

            String currStr = num.substring(index, end + 1);
            long curr = Long.parseLong(currStr);

            // First operand (no operator before it)
            if (index == 0) {

                expr.append(currStr);

                helper(num, target, end + 1,
                        expr,
                        curr,
                        curr);

                expr.setLength(len);
            }
            else {

                // +
                expr.append("+").append(currStr);

                helper(num, target, end + 1,
                        expr,
                        value + curr,
                        curr);

                expr.setLength(len);

                // -
                expr.append("-").append(currStr);

                helper(num, target, end + 1,
                        expr,
                        value - curr,
                        -curr);

                expr.setLength(len);

                // *
                expr.append("*").append(currStr);

                helper(num, target, end + 1,
                        expr,
                        value - prev + prev * curr,
                        prev * curr);

                expr.setLength(len);
            }
        }
    }

    public List<String> addOperators(String num, int target) {

        helper(num, target, 0,
               new StringBuilder(),
               0,
               0);

        return ans;
    }
}