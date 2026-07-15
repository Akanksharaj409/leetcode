class Solution {
    public void sol(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr,  int idx) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(idx == candidates.length || target < 0) {
            return;
        }
        if(candidates[idx] <= target) {
            curr.add(candidates[idx]);
            sol(candidates, target-candidates[idx], res,curr, idx);
            curr.remove(curr.size()-1);
        }
        sol(candidates, target, res,curr, idx+1);
        return;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        sol(candidates, target, res, curr, 0);

        return res;
    }
}