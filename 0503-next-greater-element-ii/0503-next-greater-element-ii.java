class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        // Create doubled array
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = nums[i % n];
        }

        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        // Traverse doubled array from right to left
        for (int i = 2 * n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // Store answer only for original array
            if (i < n) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(arr[i]);
        }

        return ans;
    }
}