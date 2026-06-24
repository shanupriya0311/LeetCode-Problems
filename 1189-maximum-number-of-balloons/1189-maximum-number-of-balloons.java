class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer>map=new HashMap<>();
        int n=text.length();
        int minnum=Integer.MAX_VALUE;
        Map<Character,Integer>freq=new HashMap<>();
        freq.put('b',1);
        freq.put('a',1);
        freq.put('l',2);
        freq.put('o',2);
        freq.put('n',1);
        boolean[] visit=new boolean[26];
        String b="balloon";
        for(int i=0;i<6;i++){
          visit[b.charAt(i)-'a']=false;
        }
        for(Character c:text.toCharArray()){
            if(freq.containsKey(c))
            map.put(c,map.getOrDefault(c,0)+1);
            visit[c-'a']=true;
        }
        for(Character s:map.keySet()){
            int k=map.get(s);
            if(s=='l' || s=='o')
            k=map.get(s)/2;
            minnum=Math.min(k,minnum);
        }
        for(int i=0;i<6;i++){
            if(!visit[b.charAt(i)-'a']){
               minnum=0;
               break;
            }
        }
        return minnum;
    }
}