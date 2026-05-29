class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=1;
        right[n-1]=1;
        int j=1;
        for(int i=0;i<n-1;i++){
            left[j++]=left[i]*nums[i];
        }
        int k=n-2;
        for(int i=n-2;i>=0;i--){
            right[k--]=right[i+1]*nums[i+1];
        }
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=left[i]*right[i];
        }
        return result;
    }
}