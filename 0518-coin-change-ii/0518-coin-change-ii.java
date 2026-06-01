class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(Integer c:coins){
            for(int i=c;i<=amount;i++){
                int ne=Math.abs(c-i);
                dp[i]+=dp[ne];   
            }
        }
        return dp[amount];
    }
}