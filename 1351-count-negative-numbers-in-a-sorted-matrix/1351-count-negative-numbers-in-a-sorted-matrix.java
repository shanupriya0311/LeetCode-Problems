class Solution {
    public int countNegatives(int[][] grid) {
        int n=grid.length;
        int count=0;
        for(int i=0;i<n;i++){
           count+=backtrack(grid,i);
        }
        return count;
    }
  
  public int backtrack(int[][] grid,int i){
    int low=0;
    int ans=-1;
     int mid=0;
    int high=grid[i].length-1;
    while(low<=high){
    mid=(low+high)/2;
     if(grid[i][mid]<0){
        ans=mid;
        high=mid-1;
     }
     else{
        low=mid+1;
     }
    }
    if(ans==-1){
        return 0;
    }
    return grid[i].length-ans;
  }
}