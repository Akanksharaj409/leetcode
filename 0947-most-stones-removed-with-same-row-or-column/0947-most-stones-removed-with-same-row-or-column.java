class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] vis = new boolean[n];
        int comp = 0;

        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                comp++;
                dfs(i, stones, vis);
            }
        }
        return n-comp;
    }

    void dfs(int node, int[][]stones, boolean[] vis) {
        vis[node] = true;

        for(int i=0; i<stones.length; i++) {
            if(!vis[i] && (stones[node][0] == stones[i][0] || stones[node][1] == stones[i][1])) {
                dfs(i, stones, vis);
            }
        }
    }
}