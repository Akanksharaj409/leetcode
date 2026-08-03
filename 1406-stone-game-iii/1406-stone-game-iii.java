class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        int dp[] = new int[n+1];
        dp[n] = 0;

        for(int i=n-1; i>=0; i--) {
            int sum = 0;
            dp[i] = Integer.MIN_VALUE;

            for(int take=1; take<=3; take++) {
                if(i+take-1 < n) {
                    sum += stoneValue[i+take-1];
                    dp[i] = Math.max(dp[i], sum-dp[i+take]);
                }
            }
        }
        if(dp[0] > 0) {
            return "Alice";
        } else if(dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}