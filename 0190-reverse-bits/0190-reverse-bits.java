class Solution {
    public int reverseBits(int n) {

        int left = 0;
        int right = 31;

        while (left < right) {

            // Extract bits at left and right positions
            int leftBit = (n >> left) & 1;
            int rightBit = (n >> right) & 1;

            // If bits are different, swap them
            if (leftBit != rightBit) {
                n ^= (1 << left);
                n ^= (1 << right);
            }

            left++;
            right--;
        }

        return n;
    }
}