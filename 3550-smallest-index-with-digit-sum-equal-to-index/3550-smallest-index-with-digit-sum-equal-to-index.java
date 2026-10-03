
class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];  // Save original number
            int sum = 0;

            while (num != 0) {
                int r = num % 10;
                sum += r;
                num /= 10;
            }

            if (sum == i) {
                return i;
            }
        }

        return -1;
    }
}