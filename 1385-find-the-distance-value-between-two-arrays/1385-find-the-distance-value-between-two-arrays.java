import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr2[j] < arr1[i] - d) {
                j++;
            }
            else if (arr2[j] > arr1[i] + d) {
                count++;
                i++;
            }
            else {
                i++;
            }
        }

        // Remaining arr1 elements have no matching arr2 elements
        count += arr1.length - i;

        return count;
    }
}