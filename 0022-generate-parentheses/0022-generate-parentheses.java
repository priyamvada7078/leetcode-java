class Solution {

    public List<String> generateParenthesis(int n) {

        List<List<String>> dp = new ArrayList<>();

        dp.add(Arrays.asList(""));

        for (int i = 1; i <= n; i++) {

            List<String> current = new ArrayList<>();

            for (int j = 0; j < i; j++) {

                for (String left : dp.get(j)) {

                    for (String right : dp.get(i - j - 1)) {

                        current.add("(" + left + ")" + right);
                    }
                }
            }

            dp.add(current);
        }

        return dp.get(n);
    }
}