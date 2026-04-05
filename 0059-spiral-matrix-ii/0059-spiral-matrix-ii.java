class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result=new int[n][n];
        int val=1;
        int left=0;
        int right=n-1;
        int top=0;
        int bottom=n-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                result[top][i]=val;
                val++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
              result[i][right]=val;
              val++;
            }
            right--;
            for(int i=right;i>=left;i--){
                result[bottom][i]=val;
                val++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                result[i][left]=val;
                val++;
            }
            left++;
        }
        return result;
    }
}