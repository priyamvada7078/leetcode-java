class Solution {
        void solve(int[] nums,List<List<Integer>> ans ,List<Integer> temp,int index){
        int n=nums.length;
        if(index==n){
            ans.add(new ArrayList<>(temp));
            return;
           }
              
                
        temp.add(nums[index]);
        solve(nums,ans,temp,index+1);
        temp.remove(temp.size()-1);
        int next = index;
while(next+1<n && nums[next]==nums[next+1]){
    next++;

        }
        solve(nums,ans,temp,next+1);
            }
 public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums, ans,temp, 0);
        return ans;
    }

}