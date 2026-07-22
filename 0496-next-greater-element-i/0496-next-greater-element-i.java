class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            int j = 0;

            // Find nums1[i] in nums2
            while (nums2[j] != nums1[i]) {
                j++;
            }

            // Search to the right
            int next = -1;
            for (int k = j + 1; k < nums2.length; k++) {
                if (nums2[k] > nums1[i]) {
                    next = nums2[k];
                    break;
                }
            }

            ans[i] = next;
        }

        return ans;
    }
}