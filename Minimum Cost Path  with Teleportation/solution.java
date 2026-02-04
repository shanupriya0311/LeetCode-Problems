class Solution {
    public int minCost(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;
        int INF = 1_000_000_000;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, INF);

        dist[0][0] = 0;
        int ans = INF;

        int[] mincostarr = new int[10002];

        for (int step = 0; step <= k; step++) {

            // Normal DP
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (i > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i-1][j] + grid[i][j]);

                    if (j > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i][j-1] + grid[i][j]);
                }
            }

            ans = Math.min(ans, dist[n-1][m-1]);
            if (step == k) break;

            Arrays.fill(mincostarr, INF);

            // Build minCostByVal
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mincostarr[grid[i][j]] =
                        Math.min(mincostarr[grid[i][j]], dist[i][j]);
                }
            }

            // Suffix minimum
            for (int v = 10000; v >= 0; v--)
                mincostarr[v] = Math.min(mincostarr[v], mincostarr[v+1]);

            // Build next layer
            int[][] next = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    next[i][j] = mincostarr[grid[i][j]];

            dist = next;
        }

        return ans;
    }
}
