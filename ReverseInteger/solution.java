class Solution {
    public int reverse(int x) {
     int count;
     if(x<0)
     {
        count=-Integer.parseInt(new StringBuilder(String.valueOf(-x)).reverse().toString());
       
     }   
     else
     {
         count=Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
       
     }
     return count;
    }
}
