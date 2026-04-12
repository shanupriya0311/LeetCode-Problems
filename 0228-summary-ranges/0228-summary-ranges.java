class Solution {
    public List<String> summaryRanges(int[] nums) {
        int i=0,j=0;
        int n=nums.length;
        List<String>result=new ArrayList<>();
        while(j<n){
            while(j<n-1 && nums[j]+1==nums[j+1]){
                j++;
            }
            if(i==j) result.add(String.valueOf(nums[i]));
            else
            result.add(new String(nums[i]+"->"+nums[j]));
            i=j+1;
            j++;
        }
        return result;
    }
}