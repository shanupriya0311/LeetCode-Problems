class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
       Arrays.sort(flights,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<=k;i++){
            int[] temp=dist.clone();
            for(int[] flight:flights){
                int s=flight[0];
                int d=flight[1];
                int c=flight[2];
                if(dist[s]!=Integer.MAX_VALUE && dist[s]+c<temp[d]){
                    temp[d]=dist[s]+c;
                }
            }
         dist=temp;
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}