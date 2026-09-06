class Solution {
    public int numEnclaves(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n-1);
        }
        for(int j=0; j<n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m-1, j);
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    void dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if(r<0 || r>=m || c<0 | c>=n || grid[r][c]==0) {
            return;
        }
        grid[r][c] = 0;
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}