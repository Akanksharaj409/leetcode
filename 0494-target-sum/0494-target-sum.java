class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int tot = 0;

        for(int i=0; i<nums.length; i++) {
            tot += nums[i];
        }

        if(Math.abs(target) > tot) {
            return 0;
        }
        if((target + tot) % 2 != 0) {
            return 0;
        }

        int sum = (target+tot) / 2;
        int dp[] = new int[sum+1];
        dp[0] = 1;

        for(int i=0; i<nums.length; i++) {
            for(int j=sum; j>=nums[i]; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[sum];

    }
}