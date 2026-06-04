class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        int m=wordDict.size();
        Set<String>set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        int j=0;
        for(int i=1;i<=n;i++){
         for(int k=0;k<i;k++){
             if(dp[k] && set.contains(s.substring(k,i))){
               dp[i]=true;
               break;
             }
         }
        }
      return dp[n];
    }
}