class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n==1) return 1;
        int[] c=new int[n+1];
        for(int[] a:trust){
            c[a[0]]--;
            c[a[1]]++;
        }
        for(int a=0;a<c.length;a++) if(c[a]==n-1) return a;
        return -1;
    }
}