class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // build graph
        for(int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];
            graph.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // add nodes with indegree 0
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            result[index++] = node;

            for(int nei : graph.get(node)) {
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        // cycle check
        if(index != numCourses) return new int[0];

        return result;
    }
}