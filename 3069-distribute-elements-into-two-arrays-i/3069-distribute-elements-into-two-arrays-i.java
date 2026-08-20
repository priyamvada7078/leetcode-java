class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        // First two operations
        arr1[0] = nums[0];
        arr2[0] = nums[1];

        // j = last index of arr1
        // k = last index of arr2
        int j = 0;
        int k = 0;

        // Start from the third element
        for (int i = 2; i < n; i++) {

            // Compare last elements
            if (arr1[j] > arr2[k]) {
                j++;
                arr1[j] = nums[i];
            } else {
                k++;
                arr2[k] = nums[i];
            }
        }

        // Create result array
        int[] result = new int[n];

        int index = 0;

        // Copy arr1
        for (int i = 0; i <= j; i++) {
            result[index++] = arr1[i];
        }

        // Copy arr2
        for (int i = 0; i <= k; i++) {
            result[index++] = arr2[i];
        }

        return result;
    }
}