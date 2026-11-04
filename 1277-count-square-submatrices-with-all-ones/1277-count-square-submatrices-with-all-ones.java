class Solution {
    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int maxK = Math.min(m - i, n - j);

                for (int k = 1; k <= maxK; k++) {

                    boolean valid = true;

                    for (int r = i; r < i + k; r++) {

                        for (int c = j; c < j + k; c++) {

                            if (matrix[r][c] == 0) {
                                valid = false;
                                break;
                            }
                        }

                        if (!valid) {
                            break;
                        }
                    }

                    if (valid) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
