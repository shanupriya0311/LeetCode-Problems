class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        if(n == 1) return true;
        for(int i=0;i<n;i++){
            prefix[i]=i+nums[i];
        }
        int maxlen=prefix[0];
        int old=maxlen;
        int i=1;
       while(i<n){
        while(i<=maxlen){
            if(prefix[i]>=n-1){
                return true;
            }
            maxlen=Math.max(prefix[i],maxlen);
            i++;
        }
        if(old == maxlen){
            break;
        }
        old=maxlen;
        i=maxlen;
        }
        return false;
    }
}