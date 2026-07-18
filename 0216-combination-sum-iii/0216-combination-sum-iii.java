class Solution {
    public void sol(List<List<Integer>> res, int k, int n, List<Integer> curr, int i) {
        if(n==0 && k==0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if(i>9) return;
        if(i<0 || k<0) return;

        curr.add(i);
        sol(res, k-1, n-i, curr, i+1);
        curr.remove(curr.size()-1);
        sol(res, k, n, curr, i+1);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        sol(res, k, n, new ArrayList(), 1);
        return new ArrayList(res);
    }
}