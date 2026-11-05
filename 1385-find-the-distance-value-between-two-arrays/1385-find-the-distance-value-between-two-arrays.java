class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;
        int m=arr1.length;
        int n=arr2.length;
        for(int i=0;i<m;i++){
            boolean valid=true;
            for(int j=0;j<n;j++){
                if(Math.abs(arr1[i]-arr2[j])<=d) {
                    valid=false;
                    break;
            }
            }
            if(valid) count++;

        }
        return count;
    }
}