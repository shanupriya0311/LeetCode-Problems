class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>stack1=new Stack<>();
        Stack<Character>stack2=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#')
            {
                 if(!stack1.isEmpty())
                 stack1.pop();
            }
            else{
                stack1.push(s.charAt(i));
            }
        }
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'){
                if(!stack2.isEmpty())
                 stack2.pop();
            }
             else{
                stack2.push(t.charAt(i));
            }
        }
     StringBuilder str1 = new StringBuilder();
     while(!stack1.isEmpty()){
      str1.insert(0,stack1.pop());  
      }
        StringBuilder str2 = new StringBuilder();
      while(!stack2.isEmpty()){
      str2.insert(0,stack2.pop());
      }
      String h1=str1.toString();
      String h2=str2.toString();
        return h1.equals(h2);
    }
}