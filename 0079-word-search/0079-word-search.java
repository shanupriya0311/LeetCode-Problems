class Solution {
    int[][] dir = {
    {1, 0},//bot
    {0, 1},//right
    {0, -1},//left
    {-1, 0}//up
};
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean result=false;
        for(int i=0;i<n && !result;i++){
            for(int j=0;j<m && !result;j++){
               boolean[][] visit=new boolean[n][m];
                if(word.charAt(0)==board[i][j]){
                   visit[i][j]=true;
                    result=backtrack(board,word,1,i,j,n,m,visit);
                }
            }
        }
           return result;
    }
    public boolean backtrack(char[][] board,String word,int start,int r,int c,int n,int m,boolean[][] visit){
        if(word.length()==start){
            return true;
        }
        for(int i=0;i<4;i++){
            int nr=r+dir[i][0];
            int nc=c+dir[i][1];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !visit[nr][nc] ){
                if(word.charAt(start)==board[nr][nc]){
                    visit[nr][nc]=true;
                    if(backtrack(board,word,start+1,nr,nc,n,m,visit)){
                        return true;
                    }
                    visit[nr][nc]=false;
                }
            }
        }
        return false;
    }
}