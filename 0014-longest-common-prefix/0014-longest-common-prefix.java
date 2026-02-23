class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        String result="";
        if(n==0){
          return result;
        }
        int m=strs[0].length();
        for(int i=0;i<m;i++){
            char str=strs[0].charAt(i);
            boolean res=true;
            for(int j=0;j<n;j++){
             if(i>=strs[j].length()|| strs[j].charAt(i)!=str){
                res &=false;
                break;
             }
             else if(strs[j].charAt(i)==str){
                res &=true;
             }
            }
            if(res){
                result+=str;
            }
            else{
                break;
            }
        }
        return result;
    }
}