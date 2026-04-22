class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String>result=new ArrayList<>();
         int change=0;
         for(int i=0;i<queries.length;i++){
            String q=queries[i];
            for(int j=0;j<dictionary.length;j++){
                if(q.length()==dictionary[j].length()){
                    change=0;
                    for(int k=0;k<q.length();k++){
                        if(q.charAt(k)!=dictionary[j].charAt(k)){           
                           change++;
                        }
                    }
                    if(change<=2){
                        result.add(q);
                        break;
                    }
                }
            }
         }
         return result;
    }
}