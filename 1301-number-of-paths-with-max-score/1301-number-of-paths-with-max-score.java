class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        int[][] matrix=new int[n][n];
        int[][] path=new int[n][n];
        int[][] dir={{-1,0},{-1,-1},{0,-1}};
        path[n-1][n-1]=1;
        for(int r=n-1;r>=0;r--){
            for(int c=n-1;c>=0;c--){
                for(int k=0;k<3;k++){
                    int nr=r+dir[k][0];
                    int nc=c+dir[k][1];
                    if(nr>=0 && nc>=0 && nr<n && nc<n && board.get(nr).charAt(nc)!='X'){
                        char ch = board.get(nr).charAt(nc);
                        int val = Character.isDigit(ch) ? ch - '0' : 0;
                        if(matrix[r][c]+val>matrix[nr][nc]){
                        matrix[nr][nc]=matrix[r][c]+val;
                        path[nr][nc]=path[r][c];}
                        else if(matrix[r][c]+val==matrix[nr][nc]){
                         path[nr][nc]=(path[r][c]+path[nr][nc])%1000000007;
                        }
                    }
                }
            }
        }
        if(path[0][0]==0){
            return new int[]{0,0};
        }
        return new int[]{matrix[0][0],path[0][0]};
    }
}