class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer>freq=new HashMap<>();
        int n=words.length*words[0].length();
        int wordcount=0;
        for(int k=0;k<words.length;k++){
            freq.put(words[k],freq.getOrDefault(words[k],0)+1);
            wordcount++;
        }
         int m=words[0].length();
        List<Integer>list=new ArrayList<>();
        for(int offset=0;offset<m;offset++){
        Map<String,Integer>map=new HashMap<>();
        int count=0;
        int i=offset;
        int j=offset;
       
        while(j<=s.length()-m){
            if(freq.containsKey(s.substring(j,j+m))){
                 map.put(s.substring(j,j+m),map.getOrDefault(s.substring(j,j+m),0)+1);
                 count++;
                  while(freq.get(s.substring(j,j+m))<map.get(s.substring(j,j+m))){
                    map.put(s.substring(i,i+m),map.get(s.substring(i,i+m))-1);
                    count--;
                    i+=m;
                 }
                 if(wordcount==count){
                     list.add(i);
                      String leftWord = s.substring(i, i + m);

                      map.put(leftWord, map.get(leftWord) - 1);
                      count--;

                       i += m;
                 }
            }
            else{
            map.clear();
            count = 0;
            i = j + m;
            }
            j+=m;
        }}
        
        return list;
    }
}