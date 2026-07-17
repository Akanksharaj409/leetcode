class Solution {
    public void sol(int[] candidates, int target, Set<List<Integer>> set, List<Integer> curr, int idx) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            set.add(new ArrayList(curr));
            return;
        }

        for(int i=idx; i<candidates.length; i++) {
            if(i>idx && candidates[i]==candidates[i-1]) {
                continue;
            }
            curr.add(candidates[i]);
            sol(candidates, target-candidates[i], set, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet();
        sol(candidates, target, set, new ArrayList(), 0);
        return new ArrayList(set);
    }
}