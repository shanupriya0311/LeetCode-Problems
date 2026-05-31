class Solution {
    int maxlen=Integer.MAX_VALUE;
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n+1];
        int sum=0;
        prefix[0]=0;
        for(int i=0;i<n;i++){
         sum+=nums[i];
         prefix[i+1]=sum;
         if(sum>=target){
            binarysearch(prefix,i+1,target);
         }
        }
        if(maxlen==Integer.MAX_VALUE){
            return 0;
        }
        return maxlen;
    }
    public void binarysearch(int[] prefix,int i,int target){
        int left=0;
        int right=i;
        int ans=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(prefix[i]-prefix[mid]>=target){
                ans=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        maxlen=Math.min(maxlen,i-ans);
    }
}