class Solution {
     int romanToInt(String s) {
        int n=s.length();
        int sum=0;
        sum+=find(s.charAt(n-1));
        for(int i=n-2;i>=0;i--){
            if(find(s.charAt(i))<find(s.charAt(i+1))){
                sum-=find(s.charAt(i));
            }
            else{
                sum+=find(s.charAt(i));
            }
        }
        return sum;
    }
    public int find(char s){
        switch(s){
            case 'I':
               return 1;
            case 'V':
               return 5;
            case 'X':
               return 10;
            case 'L':
               return 50;
               
            case 'C':
               return 100;
              
            case 'D':
               return 500;
               
            case 'M':
               return 1000;       
        }
        return 0;
    }
}