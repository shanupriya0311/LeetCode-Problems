class Solution {
    Map<Character,Integer>freq;
     Map<Character,Integer>map;
    public int longestBalanced(String s) {
        int i=0,j=0;
        int maxlen=0;
        map=new HashMap<>();
        for(i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            freq=new HashMap<>(map);
            for( j=0;j<=i;j++){
                boolean found=false;
                while(!allequals(s,j,i)){
                    if((freq.get(s.charAt(j))-1)==0){
                        freq.remove(s.charAt(j));
                    }
                    else{
                        freq.put(s.charAt(j),freq.get(s.charAt(j))-1);
                      
                        found=true;
                    }
                      j++;
                }
                maxlen=Math.max(maxlen,i-j+1);  
            }
        }
        return maxlen;
    }
    public boolean allequals(String s,int start,int end){
        int m=freq.get(s.charAt(start));
        for(Character c:freq.keySet()){
            if(freq.get(c)!=m){
                return false;
            }
        }
        return true;
    }
}