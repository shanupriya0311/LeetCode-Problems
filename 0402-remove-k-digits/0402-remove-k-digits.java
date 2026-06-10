class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>stack=new Stack<>();
        if(num.length()<=k){
          return "0";
        }
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            while(!stack.isEmpty() && k>0 && stack.peek()>ch){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while (k > 0) {
        stack.pop();
        k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        boolean zero=false;
        sb.reverse();
        int b=0;
        while(b<sb.length() && sb.charAt(b)=='0'){
           b++;
        }
        String result=sb.substring(b,sb.length());
        if(result==""){
            result="0";
        }
        return  result;
    }
}