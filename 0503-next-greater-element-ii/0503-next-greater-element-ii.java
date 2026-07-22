class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        // Create doubled array
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = nums[i % n];
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            ans[i] = -1;

            // Search in the circular part
            for (int j = i + 1; j < i + n; j++) {

                if (arr[j] > arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
        }

        return ans;
    }
}
