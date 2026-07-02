class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=Integer.MAX_VALUE;
            } 
        }
        dp[0][0]=triangle.get(0).get(0);
        for(int i=0;i<triangle.size()-1;i++){
           for(int j=0;j<triangle.get(i).size();j++){
             dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+triangle.get(i+1).get(j));
             dp[i+1][j+1]=Math.min(dp[i+1][j+1],dp[i][j]+triangle.get(i+1).get(j+1));
           }
        }
        int result=dp[n-1][n-1];
        for(int i=0;i<dp[n-1].length;i++){
            result=Math.min(result,dp[n-1][i]);
        }
        return result;
        }
}