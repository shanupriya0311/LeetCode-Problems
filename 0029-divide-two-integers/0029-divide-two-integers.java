class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign=true;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if(dividend<0 && divisor>0 || dividend>0 && divisor<0){
            sign=false;
        }
        long ans=0;
        long n=Math.abs((long)dividend);
        long divisors=Math.abs((long)divisor);
        while(divisors<=n){
           long count=-1;
           while(n>=(divisors<<(count+1))){
              count++;
           }
            ans+=(1<<count);
            n-=(divisors<<count);
        }
       return sign?(int)ans:(int)-ans;
    }
}