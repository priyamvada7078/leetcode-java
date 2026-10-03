
class Solution {
    public int minOperations(int[] nums, int x) {

        int totalSum = 0;

        // Find the sum of the entire array
        for (int num : nums) {
            totalSum += num;
        }

        // The sum we want to KEEP
        int target = totalSum - x;

        if (target < 0) {
            return -1;
        }

        int left = 0;
        int sum = 0;
        int maxLen = -1;

        // Move the right end of our window
        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            // If sum is too big, remove numbers
            // from the left side of the window
            while (sum > target) {
                sum -= nums[left];
                left++;
            }

            // If sum matches target, save its length
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        // No valid subarray was found
        if (maxLen == -1) {
            return -1;
        }

        // Elements outside the window must be removed
        return nums.length - maxLen;
    }
}