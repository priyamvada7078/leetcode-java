class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        // Count frequency of characters in s
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {

            char ch = target.charAt(i);

            // Case 1: We can keep the same character as target
            if (freq[ch - 'a'] > 0) {

                ans.append(ch);
                freq[ch - 'a']--;

            } 
            else {

                // We cannot continue matching target.
                // Try to find a character greater than target[i].
                int bigger = -1;

                for (int j = ch - 'a' + 1; j < 26; j++) {
                    if (freq[j] > 0) {
                        bigger = j;
                        break;
                    }
                }

                if (bigger != -1) {
                    // We found a bigger character.
                    ans.append((char)(bigger + 'a'));
                    freq[bigger]--;

                    // Put remaining characters in sorted order
                    for (int j = 0; j < 26; j++) {
                        while (freq[j] > 0) {
                            ans.append((char)(j + 'a'));
                            freq[j]--;
                        }
                    }

                    return ans.toString();
                }

                // No bigger character here.
                // Backtracking is needed.
                break;
            }
        }

        // We reached here because matching target failed.
        // Backtrack from the last matched position.
        for (int i = ans.length() - 1; i >= 0; i--) {

            // Restore the character used at position i
            char old = ans.charAt(i);
            freq[old - 'a']++;

            // Try to replace it with the smallest bigger character
            int bigger = -1;

            for (int j = old - 'a' + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    bigger = j;
                    break;
                }
            }

            if (bigger != -1) {

                StringBuilder result = new StringBuilder();

                // Keep everything before i
                result.append(ans.substring(0, i));

                // Put a slightly bigger character
                result.append((char)(bigger + 'a'));
                freq[bigger]--;

                // Put remaining characters in sorted order
                for (int j = 0; j < 26; j++) {
                    while (freq[j] > 0) {
                        result.append((char)(j + 'a'));
                        freq[j]--;
                    }
                }

                return result.toString();
            }
        }

        return "";
    }
}