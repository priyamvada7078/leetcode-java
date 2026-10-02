
import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = n + 1;

        int[] best = new int[n + 1];
        Arrays.fill(best, INF);

        Map<Long, Integer> last = new HashMap<>();
        last.put(0L, 0);

        long sum = 0;
        int ans = INF;

        for (int j = 0; j < n; j++) {
            sum += arr[j];

            best[j + 1] = best[j];

            long needed = sum - target;

            if (last.containsKey(needed)) {
                int start = last.get(needed);
                int len = j + 1 - start;

                if (best[start] != INF) {
                    ans = Math.min(ans, best[start] + len);
                }

                best[j + 1] = Math.min(best[j + 1], len);
            }

            // Keep the latest index for this prefix sum
            last.put(sum, j + 1);
        }

        return ans == INF ? -1 : ans;
    }
}