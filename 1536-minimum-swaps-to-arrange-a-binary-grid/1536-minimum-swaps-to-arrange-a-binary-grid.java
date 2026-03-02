class Solution {
    public int minSwaps(int[][] grid) {
       int n=grid.length;
       int m=grid[0].length;
       int[] trailing=new int[n];
       for(int i=0;i<n;i++){
        int count=0;
        for(int j=n-1;j>=0;j--){
            if(grid[i][j]==0){
                count++;
            }
            else{
                break;
            }
        }
        trailing[i]=count;
       }
       int swap=0;
      for(int i=0;i<n;i++){
        int required=m-i-1;
        int j=i;
        while(j<m && trailing[j]<required){
            j++;
        }
        if(j==m)
         return -1;
        while(j>i){
         int temp=trailing[j];
         trailing[j]=trailing[j-1];
         trailing[j-1]=temp;
         swap++;
         j--;
        }
      }
      return swap;
}}