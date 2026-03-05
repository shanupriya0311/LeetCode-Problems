class Solution {
    public int minOperations(String s) {
        StringBuilder str=new StringBuilder(s);
        int n=str.length();
        char zp='1';
        char op='0';
        int zsc=0;
        int osc=0;
        StringBuilder zstr=new StringBuilder(s);
        StringBuilder ostr=new StringBuilder(s);
        for(int i=0;i<n;i++){
          if(zp==zstr.charAt(i)){
            zsc++;
            char val=zstr.charAt(i)=='0'?'1':'0';
            zstr.setCharAt(i,val);
          }
          zp=zstr.charAt(i);
           if(op==ostr.charAt(i)){
            osc++;
            char val=ostr.charAt(i)=='0'?'1':'0';
            ostr.setCharAt(i,val);
          }
          op=ostr.charAt(i);
        }
        return osc>zsc?zsc:osc;
         
    }
}