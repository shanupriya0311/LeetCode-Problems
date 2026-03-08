class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
     StringBuilder str = new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(nums[i].charAt(i)=='0')
            {
               str.append('1');
            }
            else if(nums[i].charAt(i)=='1')
            {
               str.append('0');
            }
        }
        return str.toString();
    }
}