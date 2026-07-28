import java.util.Stack;

class Solution {

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] height = new int[cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }

            maxArea = Math.max(maxArea, largestRectangle(height));
        }

        return maxArea;
    }

    private int largestRectangle(int[] heights) {

        int n = heights.length;

        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();

            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        st.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();

            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = nse[i] - pse[i] - 1;

            int area = width * heights[i];

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}