class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        int n=arr.length;
        boolean[] visit = new boolean[n]; 
        while(!q.isEmpty()){
            int current=q.poll();
            if(visit[current]) continue;
            visit[current]=true;
            if(arr[current]==0)
             return true;
            if(current+arr[current]<n && !visit[current+arr[current]]){     
                q.add(current+arr[current]);
            }
            if( current-arr[current]>=0 && !visit[current-arr[current]]){
                q.add(current-arr[current]);
            }
        }
        return false;
    }
}