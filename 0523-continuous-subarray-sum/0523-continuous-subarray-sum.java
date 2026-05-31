class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        int[] prefix=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            prefix[i]=sum;
            if(i>=1 && prefix[i]%k==0){
                return true;
            }
        }
        map.put(0,-1);
        for(int i=0;i<n;i++){
          int v=prefix[i]%k;
          if(map.containsKey(v) &&  i-map.get(v)>=2){
            return true;
          }
          if(!map.containsKey(v)) {
                map.put(v, i);
            }
        }
       return false;
    }
}