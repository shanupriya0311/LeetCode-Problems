class Solution {
    public int maxSum(int[] nums) {
       
        int maxval=Integer.MIN_VALUE;
        ArrayList<Integer>list=new ArrayList<>();
        Set<Integer>set=new HashSet<>();
        int maxelement=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
           if(!set.contains(nums[i])){
             list.add(nums[i]);
           }
           set.add(nums[i]);
           maxelement=Math.max(maxelement,nums[i]);
        }
        int sum=0;
        int maxlen=Integer.MIN_VALUE;
        if(maxelement<0){
            return maxelement;
        }
        for(int i=0;i<list.size();i++){
          if(list.get(i)>0){
            sum+=list.get(i);
          }
          maxlen=Math.max(sum,maxlen);
        }
        return maxlen;
    }
}