class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix[0].length;
        int dp[][] = new int[n][n];

        for(int j=0; j<n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<n; j++) {
                int min = dp[i-1][j];

                if(j>0) {
                    min = Math.min(min, dp[i-1][j-1]);
                }
                if(j<n-1) {
                    min = Math.min(min, dp[i-1][j+1]);
                }
                dp[i][j] = min+matrix[i][j];
            }
        }

        int ans = dp[n-1][0];
        for(int j=1; j<n; j++) {
            ans = Math.min(ans, dp[n-1][j]);
        }
        return ans;
    }
}