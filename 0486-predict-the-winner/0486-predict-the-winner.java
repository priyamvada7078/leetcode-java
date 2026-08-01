class Solution {

    public boolean predictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1) >= 0;
    }

    private int solve(int[] nums, int i, int j) {
        // Base case
        if (i == j) {
            return nums[i];
        }

        // Choose left
        int takeLeft = nums[i] - solve(nums, i + 1, j);

        // Choose right
        int takeRight = nums[j] - solve(nums, i, j - 1);

        // Return the best score difference
        return Math.max(takeLeft, takeRight);
    }
}