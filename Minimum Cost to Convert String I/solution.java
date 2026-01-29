class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
          long total=0;
        int value=Integer.MAX_VALUE;
         int[][] dp=new int[26][26];
         for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j){
                   dp[i][j]=0;
                }
                else{
                    dp[i][j]=Integer.MAX_VALUE;
                }
            }
         }
         for(int i=0;i<original.length;i++){
              int u = original[i]- 'a';
                int v = changed[i] - 'a';
            dp[u][v]=Math.min(dp[u][v],cost[i]);
         }
         for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(dp[i][k]!=value && dp[k][j]!=value &&  dp[i][j]>dp[k][j]+dp[i][k]){
                        dp[i][j]=dp[k][j]+dp[i][k];
                    }
                }
            }}
            for(int i=0;i<source.length();i++){
                 int u = source.charAt(i) - 'a';
                int v = target.charAt(i) - 'a';
                if(dp[u][v]>=value){
                    return -1;
                }else{
                 total+=dp[u][v];
                }
            }
         
         return total;
    }
}
