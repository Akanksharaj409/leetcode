class Solution {
    List<Integer>[] graph;
    boolean[] suspicious;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < invocations.length; i++) {
            int u = invocations[i][0];
            int v = invocations[i][1];
            graph[u].add(v);
        }

        suspicious = new boolean[n];
        dfs(k);

        for (int i = 0; i < invocations.length; i++) {
            int u = invocations[i][0];
            int v = invocations[i][1];

            if (!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    ans.add(j);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(int node) {
        suspicious[node] = true;

        for (int next : graph[node]) {
            if (!suspicious[next]) {
                dfs(next);
            }
        }
    }
}