class Solution {
    Integer dp[][] = new Integer[101][101];
    int m, n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        return solve(obstacleGrid, 0, 0);
    }

    int solve(int[][] obstacleGrid, int i, int j) {
        if(i>= m || j>= n || obstacleGrid[i][j]==1) {
            return 0;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        if(i==m-1 && j==n-1) {
            return 1;
        }

        int right = solve(obstacleGrid, i, j+1);
        int down = solve(obstacleGrid, i+1, j);

        return dp[i][j] = right+down;
    }
}