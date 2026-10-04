class Solution {
    public int lastStoneWeightII(int[] stones) {
        int tot = 0;

        for(int i=0; i<stones.length; i++) {
            tot += stones[i];
        }

        int tar = tot / 2;
        int dp[] = new int[tar+1];

        for(int i=0; i<stones.length; i++) {
            for(int j=tar; j>=stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
            }
        }
        return tot-2*dp[tar];
    }
}