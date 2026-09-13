class Solution {
    int n;
    int[][] grid;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        n = grid.length;

        Map<Integer, Integer> map = new HashMap<>();
        int id = 2;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int size = dfs(i, j, id);
                    map.put(id, size);
                    id++;
                }
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();

                    for(int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] > 1) {
                            set.add(grid[nr][nc]);
                        }
                    }

                    int size = 1;

                    for(int islandId : set) {
                        size += map.get(islandId);
                    }

                    ans = Math.max(ans, size);
                }
            }
        }

        if(ans == 0) {
            return n * n;
        }

        return ans;
    }

    int dfs(int r, int c, int id) {
        if(r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = id;

        int size = 1;

        for(int k = 0; k < 4; k++) {
            size += dfs(r + dr[k], c + dc[k], id);
        }

        return size;
    }
}