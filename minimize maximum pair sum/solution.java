class Solution {
    public int minPairSum(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        int maximum=Integer.MIN_VALUE;
        Arrays.sort(nums);
        while(i<j){
            int sum=nums[i]+nums[j];
            maximum=Math.max(maximum,sum);
            i++;
            j--;
        }
        return maximum;
    }
}
