class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();

        for(List<String> account: accounts) {
            String firstEmail = account.get(1);

            graph.putIfAbsent(firstEmail, new ArrayList<>());

            for(int i=2; i<account.size(); i++) {
                String email = account.get(i);

                graph.putIfAbsent(email, new ArrayList<>());

                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);
            }
        }

        Map<String, String> emailToName = new HashMap<>();

        for(List<String> account: accounts) {
            String name = account.get(0);

            for(int i=1; i<account.size(); i++) {
                emailToName.put(account.get(i), name);
            }
        }

        Set<String> vis = new HashSet<>();
        List<List<String>> res = new ArrayList<>();

        for(String email: graph.keySet()) {
            if(vis.contains(email)) {
                continue;
            }
            List<String> emails = new ArrayList<>();
            dfs(email, graph, vis, emails);
            Collections.sort(emails);

            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(emailToName.get(email));
            mergedAccount.addAll(emails);

            res.add(mergedAccount);
        }
        return res;
    }

    void dfs(String email, Map<String, List<String>> graph, Set<String> vis, List<String> emails) {
        vis.add(email);
        emails.add(email);

        for(String neigh: graph.get(email)) {
            if(!vis.contains(neigh)) {
                dfs(neigh, graph, vis, emails);
            }
        }
    }
}