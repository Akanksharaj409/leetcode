class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int mod = 1000000007;
        int down[] = new int[n];
        down[0] = 1;

        int ans = 0;

        for(int i=0; i<m; i++) {
            int right = 0;

            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    int temp = right;
                    right = down[j];
                    down[j] = temp;
                } else {
                    int total = (right + down[j]) % mod;
                    right = total; 
                    down[j] = total;
                }
            }
            ans = right;
        }
        return ans;
    }
}