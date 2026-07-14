class Solution {

    // Function to calculate sum of prime factors (including duplicates)
    private int primeFactorSum(int n) {

        int sum = 0;
        int temp = n;

        // Find prime factors
        for (int i = 2; i * i <= temp; i++) {

            while (n % i == 0) {
                sum += i;
                n /= i;
            }
        }

        // If one prime factor is left
        if (n > 1)
            sum += n;

        return sum;
    }

    public int smallestValue(int n) {

        while (true) {

            int sum = primeFactorSum(n);

            // If n is prime or cannot be reduced further
            if (sum == n)
                return n;

            // Replace n with sum of prime factors
            n = sum;
        }
    }
}