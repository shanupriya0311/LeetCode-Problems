class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<sandwiches.length;i++){
            queue.offer(students[i]);
        }
        int i=0;
       while(!queue.isEmpty()){
            if(sandwiches[i]==queue.peek()){
                i++;
                queue.poll();
            }
            else{
               int n= queue.poll();
               queue.offer(n);
               if(!queue.contains(sandwiches[i])){
                return queue.size();
               }
            }        
        }
          return 0;
    }
}