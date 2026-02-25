class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
             if(board[i][j]=='.'){
                continue;
             }
              else if(!check(i,j,board)){
                  return false;
              }
            }
        }
        return true;
    }
    boolean check(int row,int col,char[][] board){
        //row
        for(int j=0;j<9;j++){
            if(j==col){
                continue;
            }
            else if(board[row][col]==board[row][j]){
              return false;
            }
        }
        //column
        for(int i=0;i<9;i++){
            if(row==i){
                continue;
            }
            else if(board[row][col]==board[i][col]){
              return false;
            }
        }
        //for grid
        int startrow=row-row%3;
        int startcol=col-col%3;
        for(int i=startrow;i<startrow+3;i++){
            for(int j=startcol;j<startcol+3;j++){
                if(i==row && j==col)
                 continue;
                 if(board[row][col]==board[i][j]){
                    return false;
                 }
            }
        }
        return true;
    }
}