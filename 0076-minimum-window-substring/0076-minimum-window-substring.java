class Solution {
    public String minWindow(String s, String t) {
         int sl=s.length();
         int tl=t.length();
         Map<Character,Integer>tmap=new HashMap<>();
         Map<Character,Integer>smap=new HashMap<>();
        int i=0;
        for(i=0;i<tl;i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }  
        i=0;     
        int j=0;
        int maxlen=Integer.MAX_VALUE;
        String result="";
        while(j<sl){
         if(tmap.containsKey(s.charAt(j)))
         smap.put(s.charAt(j),smap.getOrDefault(s.charAt(j),0)+1);
         while(check(smap,tmap) &&  i<=j){
            if(maxlen>(j-i+1)){
               maxlen=j-i+1;
               result=s.substring(i,j+1);
            }
            if(smap.containsKey(s.charAt(i)) && smap.get(s.charAt(i))-1==0){
                smap.remove(s.charAt(i));
            }
            else if(smap.containsKey(s.charAt(i))){
                smap.put(s.charAt(i),smap.get(s.charAt(i))-1);
            }
            i++;
         }
        j++;
        }
        return result;
    }
   public boolean check(Map<Character,Integer> smap,
                     Map<Character,Integer> tmap){

    for(Character c : tmap.keySet()){
        if(smap.getOrDefault(c,0) < tmap.get(c)){
            return false;
        }
    }

    return true;
}
}