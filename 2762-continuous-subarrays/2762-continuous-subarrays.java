class Solution {
    public long continuousSubarrays(int[] nums) {
        PriorityQueue<int[]>maxpq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        PriorityQueue<int[]>minpq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        long count=0;
        int i=0,j=0;
        int n=nums.length;
        while(j<n){
            maxpq.offer(new int[]{nums[j],j});
            minpq.offer(new int[]{nums[j],j});
                int diff=maxpq.peek()[0]-minpq.peek()[0];
                if(0<=diff &&  diff<=2){
                    count+=j-i+1;
                    j++;
                }
                else{
                    i++;
                    while(i>maxpq.peek()[1] || i>minpq.peek()[1]){
                    if(i>maxpq.peek()[1]){
                        maxpq.poll();
                    }
                    if(i>minpq.peek()[1]){
                        minpq.poll();
                    }
                }
                }
            }
          
        return count;
    }
}