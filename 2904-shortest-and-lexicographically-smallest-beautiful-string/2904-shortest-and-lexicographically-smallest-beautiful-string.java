class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int start = 0;
        int count = 0;

        int minLen = Integer.MAX_VALUE;
        String ans = "";

        for (int end = 0; end < s.length(); end++) {

            if (s.charAt(end) == '1') {
                count++;
            }

            while (count == k) {

                int currLen = end - start + 1;
                String curr = s.substring(start, end + 1);

                if (currLen < minLen ||
                    (currLen == minLen && curr.compareTo(ans) < 0)) {

                    minLen = currLen;
                    ans = curr;
                }

                if (s.charAt(start) == '1') {
                    count--;
                }

                start++;
            }
    
        }
return ans;
    }
}