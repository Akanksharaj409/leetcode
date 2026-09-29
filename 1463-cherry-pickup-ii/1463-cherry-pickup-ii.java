class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int dp[][][] = new int[rows][cols][cols];

        for(int i=0; i<rows; i++) {
            for(int j1=0; j1<cols; j1++) {
                for(int j2=0; j2<cols; j2++) {
                    dp[i][j1][j2] = -1;
                }
            }
        }

        dp[0][0][cols-1] = grid[0][0] + grid[0][cols-1];

        for(int i=1; i<rows; i++) {
            for(int j1=0; j1<cols; j1++) {
                for(int j2=0; j2<cols; j2++) {
                    int cherries;
                    if(j1 == j2) {
                        cherries = grid[i][j1];
                    } else {
                        cherries = grid[i][j1] + grid[i][j2];
                    }

                    int max = -1;
                    for(int d1=-1; d1<=1; d1++) {
                        for(int d2=-1; d2<=1; d2++) {
                            int prev1 = j1+d1;
                            int prev2 = j2+d2;

                            if(prev1>=0 && prev1<cols && prev2>=0 && prev2<cols) {
                                max = Math.max(max, dp[i-1][prev1][prev2]);
                            }
                        }
                    }

                    if(max != -1) {
                        dp[i][j1][j2] = cherries + max;
                    }
                }
            }
        }

        int ans = 0;
        for(int j1=0; j1<cols; j1++) {
            for(int j2=0; j2<cols; j2++) {
                ans = Math.max(ans, dp[rows-1][j1][j2]);
            }
        }
        return ans;
    }
}