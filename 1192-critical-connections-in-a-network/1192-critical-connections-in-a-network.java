class Solution {
    int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(List<Integer> edge: connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int dt[] = new int[n];
        int low[] = new int[n];
        int par[] =new int[n];

        Arrays.fill(par, -1);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                bridgeUtil(i, vis, par, low, dt, graph, ans);
            }
        }
        return ans;
    }

    void bridgeUtil(int u, boolean vis[], int[] par, int[] low, int[] dt, List<List<Integer>> graph, List<List<Integer>> ans) {
        vis[u] = true;
        dt[u] = low[u] = ++time;

        for(int v: graph.get(u)) {
            if(!vis[v]) {
                par[v] = u;
                bridgeUtil(v, vis, par, low, dt, graph, ans);
                low[u] = Math.min(low[u], low[v]);

                if(low[v] > dt[u]) {
                    ans.add(Arrays.asList(u, v));
                }
            }
            else if(v != par[u]) {
                low[u] = Math.min(low[u], dt[v]);
            }
        }
    }
}