class Solution {

    public void solve(int[] candidates, int target, int index,
                      List<Integer> temp, List<List<Integer>> ans) {

        // base case
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) return;

        for (int i = index; i < candidates.length; i++) {

            // pick current element
            temp.add(candidates[i]);

            // reuse same element allowed → i stays same
            solve(candidates, target - candidates[i], i, temp, ans);

            // backtrack
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
}