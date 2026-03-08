class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String s2 = s + s;
        int alt1=0;
        int alt2=0;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<s2.length();i++){
            char expected1=(i%2==0)?'0':'1';
            char expected2=(i%2==0)?'1':'0';
            if(s2.charAt(i)!=expected1) alt1++;
            if(s2.charAt(i)!=expected2) alt2++;
            if(i>=n){
             char prev1=((i-n)%2==0)?'0':'1';
            char prev2=((i-n)%2==0)?'1':'0';
            if(s2.charAt(i-n)!=prev1) alt1--;
             if(s2.charAt(i-n)!=prev2) alt2--;
            }
            if(i>=n-1){
                result=Math.min(result,Math.min(alt1,alt2));
            }
        }
        return result;
    }
}