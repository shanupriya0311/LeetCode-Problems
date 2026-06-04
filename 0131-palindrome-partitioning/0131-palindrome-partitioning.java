class Solution {
    Set<List<String>>result=new HashSet<>(); 
    public List<List<String>> partition(String s) {
        backtrack(s,0,new ArrayList<>());
        List<List<String>>results=new ArrayList<>(result);
        return results;
    }
    public void backtrack(String s,int i,List<String>subarr){
        if(s.length()==i){
            result.add(new ArrayList<>(subarr));
            return;}
        
        for(int j=i;j<s.length();j++){
            String strs=s.substring(i,j+1);
             if(palindrome(strs)){
                subarr.add(strs);
                backtrack(s,j+1,subarr);
                subarr.remove(subarr.size()-1);
            }  
        }
    }
    public boolean palindrome(String str){
        if(str.length()==1){
            return true;
        }
        if(str.length()%2==0){
            String a=str.substring(0,str.length()/2);
            String b=str.substring(str.length()/2,str.length());
            if(a.equals(new StringBuilder(b).reverse().toString())){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            String a=str.substring(0,str.length()/2);
            String b=str.substring(str.length()/2+1,str.length());
            if(a.equals(new StringBuilder(b).reverse().toString())){
                return true;
            }
            else{
                return false;
            }
        }
        }
    }
