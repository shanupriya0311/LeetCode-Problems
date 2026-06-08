class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int oddcount=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2!=0){
                oddcount++;
            }
            count+=map.getOrDefault(oddcount-k,0);
            map.put(oddcount,map.getOrDefault(oddcount,0)+1);
        }
        return count;
    }
}