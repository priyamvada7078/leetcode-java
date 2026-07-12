class Solution {
    public int hammingDistance(int x, int y) {
        int ans = 0; 
        // XOR will give 1 where the bits are different
        int xor = x^y;

        while(xor!=0){
            // If the last bit is 1, increment count 
            ans += xor & 1;

            // Right-shift to check the next bit
            xor >>=1;
        }
        return ans;
    }

}