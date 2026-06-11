class Solution {
    public boolean isBalanced(String num) {
        int n=num.length();
        int odd=0;
        int even=0;
        int i=0;
        while(i<n){
         odd+=num.charAt(i)-'0';
         i=i+2;
        }
        i=1;
        while(i<n){
            even+=num.charAt(i)-'0';
            i+=2;
        }
        if(odd==even){
            return true;
        }
        return false;
    }
}