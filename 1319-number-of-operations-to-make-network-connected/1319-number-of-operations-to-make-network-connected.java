class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) {
            return -1;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int conn[]: connections) {
            int u = conn[0];
            int v = conn[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean vis[] = new boolean[n];
        int comp = 0;

        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                comp++;
                dfs(i, graph, vis);
            }
        }
        return comp-1;
    }

    void dfs(int node, List<List<Integer>> graph, boolean[] vis) {
        vis[node] = true;

        for(int neigh: graph.get(node)) {
            if(!vis[neigh]) {
                dfs(neigh, graph, vis);
            }
        }
    }
}