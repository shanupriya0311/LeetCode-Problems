class Solution {
    char[][] grid;
    public void solveSudoku(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        grid=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              grid[i][j]=board[i][j];
            }
        }
        backtrack(0,0,grid,n,m);
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              board[i][j]=grid[i][j];
            }
        }
    }
    public boolean backtrack(int r,int c,char[][] grid,int n,int m){
              if(c==m){
                r++;
                c=0;
              }
              if(r==n){
                return true;
              }
              if(grid[r][c]!='.'){
                 return backtrack(r, c + 1, grid, n, m);
              }
                for(int k=1;k<=9;k++){
                    if(check(grid,r,c,(char)(k+48))){
                        grid[r][c]=(char)(k+48);
                        if(backtrack(r,c+1,grid,n,m)){
                            return true;
                        }
                        grid[r][c]='.';
                    }
                }
                return false;
                }
            
        
    
    public boolean check(char[][] grid,int r,int c,char k){
        for(int i=0;i<9;i++){
          if(grid[i][c]==k){
             return false;
          }
        }
        for(int j=0;j<9;j++){
            if(grid[r][j]==k){
                return false;
            }
        }
        int startrow=(r/3)*3;
        int startcolumn=(c/3)*3;
        for(int i=startrow;i<startrow+3;i++){
            for(int j=startcolumn;j<startcolumn+3;j++){
                if(grid[i][j]==k)
                  return false;
            }
        }
        return true;
    }
}