class Solution {
    int n;
    int[][] graph;
    public int minCostConnectPoints(int[][] points) {
        n=points.length;
        graph=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                 addedge(points[i][0],points[i][1],points[j][0],points[j][1],i,j);
            }
        }
        return prims();
    }
    public void addedge(int x1,int y1,int x2,int y2,int i,int j){
        int manhatten=Math.abs(x1-x2)+Math.abs(y1-y2);
        graph[i][j]=manhatten;
        graph[j][i]=manhatten;
    }
    public int prims(){
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        Set<Integer>visit=new HashSet<>();
        int sum=0;
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int index=cur[0];
            if(visit.contains(index))
              continue;
            sum+=cur[1];
            visit.add(index);
            for(int i=0;i<n;i++){
                if(!visit.contains(i)){
                  pq.add(new int[]{i,graph[index][i]});
                }
            }
        }
        return sum;
    }
}