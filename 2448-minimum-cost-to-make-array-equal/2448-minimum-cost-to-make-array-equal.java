class Solution {
    public long minCost(int[] nums, int[] cost) {
        int left=Integer.MAX_VALUE;
        int right=Integer.MIN_VALUE;
        for(int val:nums){
            left=Math.min(left,val);
            right=Math.max(right,val);
        }
        long result=Long.MAX_VALUE;
        while(left<=right){
            int mid=(left+right)/2;
            long c1=findcost(nums,cost,mid);
            long c2=findcost(nums,cost,mid+1);
            if(c1>c2){
                result=Math.min(result,c2);
                left=mid+1;
            }
            else{
                result=Math.min(result,c1);
                right=mid-1;
            }
        }
        return result;
    }
    public long findcost(int[] nums,int[] cost,int target){
         long val=0;
        for(int i=0;i<nums.length;i++){
            val+=(long)Math.abs(nums[i]-target)*cost[i];
        }
        return val;
    }
}