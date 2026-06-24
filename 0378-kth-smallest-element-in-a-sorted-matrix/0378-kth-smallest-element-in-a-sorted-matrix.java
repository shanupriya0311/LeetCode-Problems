class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix[i].length;j++){
                pq.offer(matrix[i][j]);
            }
        }

        int count=pq.size()-k;
        int g=0;
        while(g<count){
            pq.poll();
            g++;
        }
        return pq.peek();
    }
}