class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int maxlen=0;
        Arrays.sort(nums);

        Set<Integer>set=new HashSet<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                if(set.contains(nums[i]-1)){
                    count++;
                }
                else{
                    maxlen=Math.max(maxlen,count);
                    count=1;
                }
            }
        }
         maxlen=Math.max(maxlen,count);
         return maxlen;
    }
}