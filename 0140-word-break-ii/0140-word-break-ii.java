class Solution {
    List<String>result=new ArrayList<>();
     boolean[] visit;
    public List<String> wordBreak(String s, List<String> wordDict) {
        String str="";
        int n=s.length();
        visit=new boolean[n];
        for(int i=0;i<n;i++){
            visit[i]=true;
        }
        backtrack(s,wordDict,0,str);
        return result;
    }
    public void backtrack(String s,List<String>worddic,int start,String str){
        if(s.length()==start){
            int l=str.length();
            String c=str.substring(0,l-1);
            result.add(c);
            return;
        }
        for(int i=0;i<worddic.size();i++){
            int len=worddic.get(i).length();
            if(s.charAt(start)==worddic.get(i).charAt(0) && start+len<=s.length() && visit[start] && s.substring(start,start+len).equals(worddic.get(i)))      {
              backtrack(s,worddic,start+len,str+worddic.get(i)+' ');
            }
        }
    }
}