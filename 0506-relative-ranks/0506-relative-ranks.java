class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer>q=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<score.length;i++){
            q.add(score[i]);
        }
        Map<Integer,String>map=new HashMap<>();
        map.put(q.poll(),"Gold Medal");
           map.put(q.poll(),"Silver Medal");
          map.put(q.poll(),"Bronze Medal");
            int j=4;
            for(int i=3;i<score.length;i++){
              String s=String.valueOf(j);
              j++;
              map.put(q.poll(),s);
            }
            int m=score.length;
            String[] result=new String[m];
            for(int i=0;i<m;i++){
                String data=map.get(score[i]);
                result[i]=data;
            }
            return result;
    }
}