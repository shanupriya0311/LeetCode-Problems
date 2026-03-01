class Solution {
    public int minPartitions(String n) {
        int maxvalue=0;
        int i=0;
        while(i<n.length()){
        int y=n.charAt(i)-'0';
         maxvalue=Math.max(maxvalue,y);
         i++;
        }
        return maxvalue;
    }
}