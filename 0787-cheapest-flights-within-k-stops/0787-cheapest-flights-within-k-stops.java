class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int dist[] = new int[n];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for(int i=0; i<=k; i++) {
            int[] temp = dist.clone();
            for(int[] flight: flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if(dist[from] != INF) {
                    temp[to] = Math.min(temp[to], dist[from]+price);
                }
            }
            dist = temp;
        }
        return dist[dst] == INF? -1: dist[dst];
    }
}