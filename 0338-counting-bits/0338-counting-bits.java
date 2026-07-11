class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {

            if (i == 0) {
                ans[i] = 0;
            } else if ((i & (i - 1)) == 0) {
                // Power of 2
                ans[i] = 1;
            } else {
                int num = i;
                int count = 0;

                while (num > 0) {
                    count += (num & 1);
                    num >>= 1;
                }

                ans[i] = count;
            }
        }

        return ans;
    }
}