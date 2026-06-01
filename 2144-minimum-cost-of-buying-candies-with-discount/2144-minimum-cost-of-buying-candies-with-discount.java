class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum=0;
        int n=cost.length;
        if(n==1) return cost[0];
        for(int i=n-1;i>=0;){
           sum+=cost[i];
           if(i-1>=0) {
            sum+=cost[i-1];
           }     
           i=i-3;
        }
        return sum;
    }
}