class Solution {
    public int[] shuffle(int[] nums, int n) {

        // Store y-values in x-values
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] | (nums[i + n] << 10);
        }

        int index = 2 * n - 1;

        // Decode from back
        for (int i = n - 1; i >= 0; i--) {

            int x = nums[i] & 1023;      // lower 10 bits
            int y = nums[i] >> 10;       // higher bits

            nums[index--] = y;
            nums[index--] = x;
        }

        return nums;
    }
}