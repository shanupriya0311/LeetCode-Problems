import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int INF = Integer.MAX_VALUE;

        // Build graph
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];

            graph[u][v] = Math.min(graph[u][v], w);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        Set<Integer> visited = new HashSet<>();

        pq.offer(new int[]{k - 1, 0});

        int answer = 0;

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            int node = cur[0];
            int dist = cur[1];

            if (visited.contains(node))
                continue;

            visited.add(node);
            answer = dist;

            for (int next = 0; next < n; next++) {

                if (graph[node][next] != INF && !visited.contains(next)) {
                    pq.offer(new int[]{next, dist + graph[node][next]});
                }
            }
        }

        if (visited.size() != n)
            return -1;

        return answer;
    }
}