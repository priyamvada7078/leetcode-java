class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(candidates, target, 0, temp, ans);

        return ans;
    }

    void solve(int[] candidates, int target, int index,
               List<Integer> temp, List<List<Integer>> ans) {

        // Base cases
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        // Include current element
        temp.add(candidates[index]);
        solve(candidates, target - candidates[index], index, temp, ans);
        temp.remove(temp.size() - 1); // Backtrack

        // Exclude current element
        solve(candidates, target, index + 1, temp, ans);
    }
}