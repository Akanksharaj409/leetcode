class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault((nums[i]), 0) +1);
        }
            for(Integer key : hm.keySet()) {
                if(hm.get(key)>nums.length/2) {
                    ans = key;
                }
            }
        return ans;
    }
}