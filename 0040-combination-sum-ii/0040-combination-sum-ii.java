class Solution {
    Set<List<Integer>>list=new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer>subarr=new ArrayList<>();
        backtrack(candidates,target,0,0,subarr);
        List<List<Integer>>s=new ArrayList<>(list);
        return s;
    }
    public void backtrack(int[] arr,int target,int index,int sum,List<Integer>subarr){
        if(sum==target){
            Collections.sort(subarr);
            list.add(new ArrayList<>(subarr));
            return;
        }
        else if(sum>target){
            return;
        }
        Arrays.sort(arr);
        for(int i=index;i<arr.length;i++){
             if(i>index && arr[i]==arr[i-1]) continue;
            subarr.add(arr[i]);
            backtrack(arr,target,i+1,sum+arr[i],subarr);
            subarr.remove(subarr.size()-1); 
        }
    }
}