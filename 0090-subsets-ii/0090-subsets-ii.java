class Solution {
    public void sol(Set<List<Integer>> res, int[] nums, List<Integer> curr, int idx) {
        if(!res.contains(curr)) {
            res.add(new ArrayList(curr));
        }

        for(int i=idx; i<nums.length; i++) {
            if(i>idx && nums[i] == nums[i-1]) {
                continue;
            }
            curr.add(nums[i]);
            sol(res, nums, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        sol(res, nums, new ArrayList(), 0);;
        return new ArrayList(res);
    }
}