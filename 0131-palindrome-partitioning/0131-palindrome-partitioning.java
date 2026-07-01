class Solution {
    public boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public void solve(String s,List<String> curr,List<List<String>> ans,int index){
        if(index==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int end=index;end<s.length();end++){
            if(isPalindrome(s,index,end)){
                curr.add(s.substring(index,end+1));
                solve(s,curr,ans,end+1);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> curr=new ArrayList<>();
        solve(s,curr,ans,0);
        return ans;
    }
}