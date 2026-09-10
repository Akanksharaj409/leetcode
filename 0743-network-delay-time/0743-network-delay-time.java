class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] time: times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph[u].add(new int[] {v, w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);

        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int node = curr[0];
            int distance = curr[1];

            if(distance > dist[node]) {
                continue;
            }

            for(int[] neighbour: graph[node]) {
                int nextNode = neighbour[0];
                int weight = neighbour[1];

                int newDist = distance + weight;

                if(newDist<dist[nextNode]) {
                    dist[nextNode] = newDist;

                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }

        int ans = 0;
        for(int i=1; i<=n; i++) {
            if(dist[i]==Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}