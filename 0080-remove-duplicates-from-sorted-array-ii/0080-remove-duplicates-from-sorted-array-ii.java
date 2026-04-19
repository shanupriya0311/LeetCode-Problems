class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int j=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int key=nums[i];
            if(map.containsKey(key)){
                if(map.get(key)<2){
                    map.put(key,map.get(key)+1);
                    nums[j++]=nums[i];
                    sum++;
                }
            }
            else{
                map.put(key,1);
                nums[j++]=nums[i];
                sum++;
            }
        }
        return sum;
    }
}