class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean[] dp=new boolean[n];
        dp[0]=true;
        for(int i=0;i<n;i++){
           int k=nums[i]+i;
           if(dp[i]){
             for(int j=i;j<=k && j<n;j++){
              dp[j]=true;
           }
           }
        }
        return dp[n-1];
    }
}