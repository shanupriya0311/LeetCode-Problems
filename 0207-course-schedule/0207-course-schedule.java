class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0){
            return true;
        }
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            int a=p[0];
            int b=p[1];
            adj.get(b).add(a);
        }
        int[] indegree=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        Queue<Integer>result=new LinkedList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            result.add(node);
            for(int neighbour:adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        if(result.size()==numCourses){
            return true;
        }
        else{
            return false;
        }
    }
}