class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = {-1, -1};

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        int firstCritical = -1;
        int previousCritical = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        while (curr.next != null) {

            // Check if curr is a critical point
            boolean isMax = curr.val > prev.val && curr.val > curr.next.val;
            boolean isMin = curr.val < prev.val && curr.val < curr.next.val;

            if (isMax || isMin) {

                // First critical point
                if (firstCritical == -1) {
                    firstCritical = index;
                } 
                else {
                    // Distance from previous critical point
                    minDistance = Math.min(
                        minDistance,
                        index - previousCritical
                    );

                    // Distance from first critical point
                    maxDistance = index - firstCritical;
                }

                // Current critical point becomes previous
                previousCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // If fewer than 2 critical points
        if (previousCritical == firstCritical) {
            return ans;
        }

        ans[0] = minDistance;
        ans[1] = maxDistance;

        return ans;
    }
}