class Solution {

    public int countBits(int n) {
        int count = 0;

        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }

        return count;
    }

    public List<String> readBinaryWatch(int turnedOn) {

        List<String> ans = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {

                if (countBits(hour) + countBits(minute) == turnedOn) {

                    ans.add(String.format("%d:%02d", hour, minute));
                }
            }
        }

        return ans;
    }
}