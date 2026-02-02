class Solution {
    public int minCost(int n, int[][] edges) {
        ArrayList<List<int[]>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
           graph.add(new ArrayList<>());
        }
       for (int i = 0; i < edges.length; i++) {
    int s = edges[i][0];
    int d = edges[i][1];
    int c = edges[i][2];
    graph.get(s).add(new int[]{d,c}); 

    graph.get(d).add(new int[]{s,2*c});
}

       PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
       int[] dist=new int[n];
       for(int i=0;i<n;i++){
        dist[i]=Integer.MAX_VALUE;
       }
       dist[0]=0;
       pq.add(new int[]{0,0});
       while(!pq.isEmpty()){
        int[] cur=pq.poll();
        int u=cur[0];
        int cost=cur[1];  
        if(cost>dist[u]){
            continue;
        }
        if(u==n-1){
            return cost;
        }
        for(int[] i:graph.get(u)){
            int node=i[0];
            int val=i[1];
            if(dist[u]+val<dist[node]){
                 dist[node]=dist[u]+val;
                    pq.add(new int[]{node,dist[node]});
                }  
            }
        }
       
      return -1;
    }
}
