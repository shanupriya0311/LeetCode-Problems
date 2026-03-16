class Solution {
    public int bitwiseComplement(int n) {
        String binary=Integer.toBinaryString(n);
        String onescomp="";
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='0'){
                onescomp+='1';
            }
            else{
                onescomp+='0';
            }
        }
        int decimal=Integer.parseInt(onescomp,2);
        return decimal;
    }
}