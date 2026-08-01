class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> st = new Stack<>();
        int[] ans=new int[temp.length];
        for(int i=temp.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()[0]<=temp[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
               ans[i]=0;
            } else {
                ans[i]=st.peek()[1]-i;
            }

           st.push(new int[]{temp[i], i});
        }
        return ans;
        
    }
}