class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        Arrays.sort(nums);
        int maxlen=1;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            set.add(nums[i]);
        }
        if(map.containsKey(1)){
        int ones = map.get(1);
        maxlen = Math.max(maxlen, ones % 2 == 0 ? ones - 1 : ones);
         }
        for(int i=0;i<n;i++){
            int count=0;
            boolean found=false;
            long cur=nums[i];
            if(cur==1){
               continue;
            }
            while(cur <= Integer.MAX_VALUE  && set.contains((int)cur)){
                int freq = map.getOrDefault((int)cur, 0);
                if (freq==0)
                    break;
                if(freq >=2){
                   count+=2;
                   cur=cur*cur;
                }
                else{
                    count++;
                    found=true;
                    break;
                }
            }
            if(!found){
                count--;
            }
            maxlen=Math.max(maxlen,count);
        }
        return maxlen;
    }
}