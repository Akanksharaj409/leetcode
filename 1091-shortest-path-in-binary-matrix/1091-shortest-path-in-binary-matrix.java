class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0]==1 || grid[n-1][n-1]==1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0] = 1;

        int dirs[][] = {{-1,-1}, {-1,0}, {-1, 1}, {0,-1}, {0,1}, {0,1}, {1, -1}, {1,0}, {1,1}};
        int dist = 1;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                int curr[] = q.poll();
                int row = curr[0];
                int col = curr[1];

                if(row == n-1 && col == n-1) {
                    return dist;
                }

                for(int[] dir : dirs) {
                    int nr = row+dir[0];
                    int nc = col+dir[1];

                    if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0) {
                        grid[nr][nc] = 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}