class Solution {
    public int findMiddleIndex(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        int result=-1;
        int sum=0;
        for(int i=0;i<n;i++){
        sum+=nums[i];
        prefix[i]=sum;
        }
        sum=0;
        int[] sufix=new int[n];
        for(int i=n-1;i>=0;i--){
         sum+=nums[i];
         sufix[i]=sum;
        }
        for(int i=0;i<n;i++){
         if(prefix[i]-nums[i]==sufix[i]-nums[i]){
            result=i;
            break;
         }
        }
        return result;
    }
}