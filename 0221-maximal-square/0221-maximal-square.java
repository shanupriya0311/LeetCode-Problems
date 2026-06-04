class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n+1][m+1];
        int maxlen=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                }
                maxlen=Math.max(maxlen,dp[i][j]);
            }
        }
        return maxlen*maxlen;
    }
}