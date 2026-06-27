class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                map.put(words[i].charAt(j),map.getOrDefault(words[i].charAt(j),0)+1);
            }
        }
        for(Character c:map.keySet()){
            if((map.get(c)%words.length)!=0){
                return false;
            }
        }
        return true;
    }
}