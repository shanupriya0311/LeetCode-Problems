class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int INF = Integer.MAX_VALUE;

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Relax all edges k+1 times
        for (int i = 0; i <= k; i++) {

            // Copy previous distances
            int[] temp = dist.clone();

            for (int[] flight : flights) {

                int u = flight[0];
                int v = flight[1];
                int cost = flight[2];

                if (dist[u] != INF && dist[u] + cost < temp[v]) {
                    temp[v] = dist[u] + cost;
                }
            }

            dist = temp;
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}