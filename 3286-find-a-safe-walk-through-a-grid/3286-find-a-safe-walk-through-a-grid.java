class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
       PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
       pq.offer(new int[]{0,0,grid.get(0).get(0)});
       int m=grid.get(0).size();
       int n=grid.size();
       int[][] dist=new int[n][m];
       for(int[] row:dist){
        Arrays.fill(row,Integer.MAX_VALUE);
       }
       int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
       dist[0][0]=grid.get(0).get(0);
       while(!pq.isEmpty()){
         int[] cur=pq.poll();
         int r=cur[0];
         int c=cur[1];
         if(cur[2]>dist[r][c])
             continue;
         if((r==n-1) && (c==m-1) && cur[2]<health){
            return true;
         }
         for(int i=0;i<4;i++){
            int nr=r+dir[i][0];
            int nc=c+dir[i][1];
            if(nr>=0 && nc>=0 && nr<n && nc<m){
                int cost=cur[2]+grid.get(nr).get(nc);
                if(cost<dist[nr][nc]){
                    dist[nr][nc]=cost;
                    pq.offer(new int[]{nr,nc,dist[nr][nc]});
                }  
            }
         }
       
       }
        return false;
    }

}