class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        int result=backtrack(nums,target,0,0);
        return result;
    }
    public int backtrack(int[] nums,int target,int sum,int i){
        if(i==nums.length){
            if(sum==target)
            return 1;
            else
            return 0;
        }
           int minus = backtrack(nums,target,sum-nums[i],i+1);
           int plus =  backtrack(nums,target,sum+nums[i],i+1);
          return minus+plus;     
    }
}