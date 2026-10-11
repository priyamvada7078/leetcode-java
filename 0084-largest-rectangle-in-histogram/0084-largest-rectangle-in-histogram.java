class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        long maxarea = 0; // Use long to store large area values
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : arr[i];
            while (!st.isEmpty() && h < arr[st.peek()]) {
                long height = arr[st.pop()]; // Cast height to long
                long width = st.isEmpty() ? i : i - st.peek() - 1;
                long area = height * width;
                maxarea = Math.max(maxarea, area);
            }
            if (i < n) {
                st.push(i);
            }
        }
        return (int) maxarea; // Cast back if function requires int
    }
}
