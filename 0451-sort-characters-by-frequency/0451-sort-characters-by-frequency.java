class obj{
    int num;
    char c;
    public obj(char c,int num){
        this.num=num;
        this.c=c;
    }
}
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<obj>pq=new PriorityQueue<>((a,b)->b.num-a.num);
        for(Character ch:map.keySet()){
            obj o=new obj(ch,map.get(ch));
            pq.add(o);
        }
        StringBuilder str=new StringBuilder();
        while(!pq.isEmpty()){
            obj k=pq.poll();
            str.append(String.valueOf(k.c).repeat(k.num));
        }
        String strs=str.toString();
        return strs;
    }
}