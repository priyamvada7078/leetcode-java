class Solution {
    public int divide(int dividend, int divisor) {

        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to avoid overflow
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;

        while (dvd >= dvs) {

            int shift = 0;

            while (dvd >= (dvs << (shift + 1))) {
                shift++;
            }

            quotient += (1 << shift);
            dvd -= (dvs << shift);
        }

        return negative ? -quotient : quotient;
    }
}