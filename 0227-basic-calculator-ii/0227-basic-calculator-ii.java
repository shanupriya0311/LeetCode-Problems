class Solution {
    public int calculate(String s) {
     Stack<Integer>num=new Stack<>();
     Stack<Character>ope=new Stack<>();
     int n=0;
     for(int i=0;i<s.length();i++){
        if(Character.isDigit(s.charAt(i))){
            while(i<s.length()){
                if(Character.isDigit(s.charAt(i))){
                    n=n*10+s.charAt(i)-'0';
                    i++;
                }
                else{
                    break;
                }}    
            num.push(n);
            n=0;
            i--;
        }
        if(s.charAt(i)==' ')
          continue;
        if(s.charAt(i)=='+' ||s.charAt(i)=='-' ||s.charAt(i)=='*' ||s.charAt(i)=='/'){
            if(!ope.isEmpty() && precedence(ope.peek())>=precedence(s.charAt(i))){
                do{
                int a=num.pop();
                int b=num.pop();
                int o=ope.pop();
                if(o=='+') num.push(b+a);
                if(o=='-') num.push(b-a);
                if(o=='*') num.push(b*a);
                if(o=='/') num.push(b/a);}
                while(!ope.isEmpty() && precedence(ope.peek())>=precedence(s.charAt(i)));
            }
            ope.push(s.charAt(i));
        }
     }
    while(!ope.isEmpty()){
        int o=ope.pop();
        int a=num.pop();
        int b=num.pop();
        if(o=='+') num.push(a+b);
        if(o=='-') num.push(b-a);
        if(o=='*') num.push(b*a);
        if(o=='/') num.push(b/a);
     } 
     return num.pop();
    }
    public int precedence(char o){
        if(o=='/' || o=='*') return 2;
        if(o=='+' || o=='-') return 1;
        return 0;
    }
}