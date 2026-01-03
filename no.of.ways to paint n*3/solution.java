class Solution {
    public int numOfWays(int n) {
        final long maximum=1000000007L;
        long aba=6;
        long abc=6;
        for(int i=2;i<=n;i++){
            long newa=(aba*3+abc*2)%maximum;
            long newb=(aba*2+abc*2)%maximum;
            aba=newa;
            abc=newb;
        }
        return (int)((aba+abc)%maximum);
    }
}
