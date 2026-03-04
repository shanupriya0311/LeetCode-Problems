class Solution {
    public int numSpecial(int[][] mat) {
       int n=mat.length;
       int m=mat[0].length;
       int count=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(mat[i][j]==1){
                if(check(i,j,mat,n,m)){
                    count++;
                }
            }
        }}
        return count;
       }
       public boolean check(int row,int col,int[][] mat,int n,int m){
         for(int i=0;i<m;i++){
            if(i==col){
                continue;
            }
            else if(mat[row][i]==1){
              return false;
            }
         }
         for(int i=0;i<n;i++){
            if(i==row){
                continue;
            }
            else if(mat[i][col]==1){
              return false;
            }
         }
         return true;
       }
    }