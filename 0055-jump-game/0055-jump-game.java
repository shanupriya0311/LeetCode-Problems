class Solution {
    public boolean canJump(int[] nums) {
        Queue<Integer>pq=new LinkedList<>();
        pq.add(0);
        int n=nums.length;
        boolean[] visit=new boolean[n];
        if(n==1){
            return true;
        }
        while(!pq.isEmpty()){
            int i=pq.poll();
            int count=1;
            while(count<=nums[i] && i+count<=n-1){
              if(!visit[i+count]){
                visit[i+count]=true;
                pq.add(i+count);
              }
              count++;
            }
        }
        if(visit[n-1]){
            return true;
        }
        else{
            return false;
        }
    }
}