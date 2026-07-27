class Solution {

    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Greater
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i])
                st.pop();

            prevGreater[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Greater
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i])
                st.pop();

            nextGreater[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // Previous Smaller
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i])
                st.pop();

            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i])
                st.pop();

            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long maxSum = 0;
        long minSum = 0;

        for (int i = 0; i < n; i++) {

            long left = i - prevGreater[i];
            long right = nextGreater[i] - i;
            maxSum += (long) nums[i] * left * right;

            left = i - prevSmaller[i];
            right = nextSmaller[i] - i;
            minSum += (long) nums[i] * left * right;
        }

        return maxSum - minSum;
    }
}