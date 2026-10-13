
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] freq = new int[100001];
        long totalDiff = 0;
        int maxDiff = 0;

        // Calculate differences and their frequencies
        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
            totalDiff += d;
            maxDiff = Math.max(maxDiff, d);
        }

        long k = (long) k1 + k2;

        // If all differences can become zero
        if (k >= totalDiff) {
            return 0;
        }

        // Reduce the largest differences first
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            int reduce = (int) Math.min(k, freq[d]);

            freq[d] -= reduce;
            freq[d - 1] += reduce;
            k -= reduce;
        }

        // Calculate the minimum sum of squared differences
        long ans = 0;

        for (int d = 1; d < freq.length; d++) {
            ans += (long) freq[d] * d * d;
        }

        return ans;
    }
}
