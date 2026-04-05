class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int m=nums.length-k+1;
        int[] result=new int[m];
        for(int i=0;i<k;i++){
         pq.add(new int[]{nums[i],i});
        }
        int j=0;
        result[j++]=pq.peek()[0];
        int l=k;
        int s=0;
        while(l<nums.length){
          s++;
          pq.add(new int[]{nums[l],l});
          l++;
          while(pq.peek()[1]<s){
            pq.poll();
          }
         result[j++]=pq.peek()[0];  
        }
        return result;
    }
}