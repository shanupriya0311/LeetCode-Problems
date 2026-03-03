class Solution {
    public char findKthBit(int n, int k) {
        String strcur="0";
        for(int i=2;i<=n;i++){
            String strprev=strcur;
            String invertval=invert(strprev);
            String reverse=new StringBuilder(invertval).reverse().toString();
            strcur=strprev+"1"+reverse;
        }
        char result=strcur.charAt(k-1);
        return result;
    }
    public String invert(String strprev){
        StringBuilder str=new StringBuilder(strprev);
        int m=str.length();
        for(int i=0;i<m;i++){
            if(str.charAt(i)=='0'){
                str.setCharAt(i,'1');
            }
            else{
                str.setCharAt(i,'0');
            }
        }
        return str.toString();
    }
}