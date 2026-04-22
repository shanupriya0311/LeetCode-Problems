class Solution {
    List<List<Integer>>result=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer>list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        backtrack(list,new ArrayList<>(),0,k,n);
        return result;
    }
    public void backtrack(List<Integer>list,List<Integer>subarr,int start,int k,int n){
        if(subarr.size()==k){
            result.add(new ArrayList<>(subarr));
            return;
        }
        for(int i=start;i<n;i++){
            subarr.add(list.get(i));
            backtrack(list,subarr,i+1,k,n);
            subarr.remove(Integer.valueOf(list.get(i)));
        }
    }
}