class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int e=prerequisites[i][0];
            int s=prerequisites[i][1];
            list.get(s).add(e);
        }
        List<Boolean>result=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int s=queries[i][1];
             int e=queries[i][0];
             Set<Integer>visit=new HashSet<>();
            visit.add(s);
            result.add(backtrack(list,s,e,visit));
        }
      return result;
    }
    public boolean backtrack(List<List<Integer>>list,int s,int e,Set<Integer>visit){
        if(s==e)
        return true;
        for(int i=0;i<list.get(s).size();i++){
            if(backtrack(list,list.get(s).get(i),e,visit)){
                return true;
            }
        }
        return false;
    }
}