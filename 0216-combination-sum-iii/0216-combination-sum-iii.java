class Solution {
   List<List<Integer>>result=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums=new int[9];
        for(int i=0;i<9;i++){
           nums[i]=i+1;
        }
        List<Integer>subset=new ArrayList<>();
        backtrack(nums,subset,n,0,k,0);
        return result;
    }
   public void backtrack(int[] nums,List<Integer>subset,int target,int j,int k,int sum){
    if(subset.size()==k && sum==target){
        result.add(new ArrayList<>(subset));
        return;
    }
    else if(subset.size()==k){
        return;
    }
    for(int i=j;i<9;i++){
        subset.add(nums[i]);
        backtrack(nums,subset,target,i+1,k,sum+nums[i]);
        subset.remove(subset.size()-1);
    }
   }
}