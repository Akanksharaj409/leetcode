class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            for(int j=i+1; j<nums.length; j++) {
                if(j>i+1 && nums[j]==nums[j-1]) {
                    continue;
                }
                int left=j+1;
                int right=nums.length-1;
        
                while(left<right) {
                    long sum = (long)nums[left]+nums[right]+nums[i]+nums[j];
            
                    if(sum==target) {
                        List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        result.add(ans);
                        while(left<right && nums[left]==nums[left+1]) left++;
                        while(left<right && nums[right]==nums[right-1]) right--;
                        left++; 
                        right--;
                    } else if(sum<target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            
        }
        return result;
    }
}