
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        Integer[] arr = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) ->
            Long.compare(Math.abs((long) a), Math.abs((long) b))
        );

        long ans = 0;
        int n = arr.length;
        int positiveCount = (n + 1) / 2;

        for (int i = 0; i < n; i++) {
            long square = (long) arr[i] * arr[i];

            if (i < n - positiveCount) {
                ans -= square;
            } else {
                ans += square;
            }
        }

        return ans;
    }
}
