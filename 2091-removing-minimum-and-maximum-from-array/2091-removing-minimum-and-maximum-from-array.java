class Solution {

    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int pos1 = 0;
        int pos2 = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] < min) {
                min = nums[i];
                pos1 = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                pos2 = i;
            }
        }

        int left = Math.min(pos1, pos2);
        int right = Math.max(pos1, pos2);

        // Both from left
        int count1 = right + 1;

        // Both from right
        int count2 = n - left;

        // One from left and one from right
        int count3 = (left + 1) + (n - right);

        return Math.min(count1, Math.min(count2, count3));
    }
}