class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] last = new int[128];

        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            left = Math.max(left, last[ch]);

            last[ch] = right + 1;

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}