class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            int num = i;  // copy of i
            int count = 0;
            
            // Brian Kernighan’s Algorithm
            while (num > 0) {
                num = num & (num - 1); // removes the lowest set bit
                count++;
            }
            
            ans[i] = count; // store result
        }
        
        return ans;
    }
}
