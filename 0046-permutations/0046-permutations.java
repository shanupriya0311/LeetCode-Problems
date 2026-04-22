class Solution {
    List<List<Integer>>result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        backtrack(nums,0,n);
        return result;
    }
    public void  backtrack(int[] nums,int start,int n){
        if(start==n){
           List<Integer> temp = new ArrayList<>();
           for (int num : nums) {
           temp.add(num);
            }
           result.add(temp);
           return;
        }
        for(int i=start;i<n;i++){
             swap(nums,start,i);
             backtrack(nums,start+1,n);
             swap(nums,start,i);
        }
    }
    public void swap(int[] nums,int start,int i){
        int temp=nums[start];
        nums[start]=nums[i];
        nums[i]=temp;
    }
}