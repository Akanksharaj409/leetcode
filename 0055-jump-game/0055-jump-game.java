class Solution {
    public boolean canJump(int[] nums) {
        int far = 0;

        for(int i=0; i<nums.length-1; i++) {
            if(i <= far) {
                far = Math.max(far, i+nums[i]);
            }
        }

        return far >= nums.length-1;
            
    }
}