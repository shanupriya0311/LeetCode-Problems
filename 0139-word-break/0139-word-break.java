class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo=new Boolean[s.length()];
        return backtrack(s,wordDict,0);
    }
    public boolean backtrack(String s,List<String>worddic,int start){
        if(start==s.length()){
            return true;
        }
        if(memo[start]!=null){
            return memo[start];
        }
        for(int i=0;i<worddic.size();i++){
            if(s.charAt(start)==worddic.get(i).charAt(0)){
                int len=worddic.get(i).length();
                if(start+len<=s.length()){
                    if(s.substring(start,start+len).equals(worddic.get(i))){
                    if(backtrack(s,worddic,start+len)){
                        memo[start]=true;
                        return true;
                    }
                }
            }}
                }
            memo[start]=false;
            return false;
        }
};