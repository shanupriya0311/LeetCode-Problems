class Solution {
    int result=Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<roads.length;i++){
          int s=roads[i][0];
          int d=roads[i][1];
          int c=roads[i][2];
          graph[s].add (new int[]{d,c});
          graph[d].add(new int[]{s,c});
        }
        boolean[] visit=new boolean[n+1];
        backtrack(graph,1,n,visit);
        return result;
    }
    public void backtrack(List<int[]>[] graph,int s,int e,boolean[] visit){
       visit[s]=true;
       for(int i=0;i<graph[s].size();i++){
        if(graph[s].get(i)[1]!=Integer.MAX_VALUE){
            result=Math.min(result,graph[s].get(i)[1]);
            if(!visit[graph[s].get(i)[0]]){
                backtrack(graph,graph[s].get(i)[0],e,visit);
            }
        }
       }
    }
}