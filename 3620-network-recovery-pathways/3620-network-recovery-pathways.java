class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
         int n=online.length;
         List<int[]>[] graph=new ArrayList[n];
         for(int i=0;i<n;i++){
             graph[i] = new ArrayList<>();
         }
         int low=0,high=0;
          for (int i = 0; i < edges.length; i++) {
            int s=edges[i][0];
            int d=edges[i][1];
            graph[s].add(new int[]{d,edges[i][2]});
            high=Math.max(high,edges[i][2]);
         }
         int ans=-1;
         while(low<=high){
            int mid=(low+high)/2;
            if(check(graph,mid,online,k)){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
         }
        return ans;
    }
    public  boolean check(List<int[]>[] grid,int mid,boolean[] online,long k){
         PriorityQueue<long[]>pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
         pq.offer(new long[]{0,0});
         long[] dist=new long[online.length];
         for(int i=0;i<online.length;i++){
            dist[i]=Long.MAX_VALUE;
         }
         dist[0]=0;
         while(!pq.isEmpty()){
            long[] cur=pq.poll();
            int node=(int)cur[0];
            long cost=cur[1];
            if(cost>dist[node])
               continue;
              for (int[] edge : grid[node]) {
                int nxt=edge[0];
                int wt=edge[1];
                if( online[nxt] && wt>=mid && dist[nxt]>cost+wt){
                   dist[nxt]=cost+wt;
                   pq.offer(new long[]{nxt,dist[nxt]});
                }
            }
         }
         return dist[online.length-1]<=k;
    }
}