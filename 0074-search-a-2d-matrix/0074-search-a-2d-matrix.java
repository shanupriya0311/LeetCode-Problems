class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            if(matrix[i][0]<= target && target<=matrix[i][matrix[i].length-1]){
                int left=0;
                int right=matrix[i].length-1;
                while(left<=right){
                   int mid=(left+right)/2;
                   if(matrix[i][mid]==target){
                    return true;
                   }
                   else if(matrix[i][mid]>target){
                       right=mid-1;
                   }
                   else{
                    left=mid+1;
                   }
                }
            }
        }
        return false;
    }
}