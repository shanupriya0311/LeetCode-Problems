class Solution {
    int n;
    int[] parent;
    public int findCircleNum(int[][] isConnected) {
        n=isConnected.length;
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]!=0){
                    int rootx=find(i);
                    int rooty=find(j);
                    parent[rooty]=rootx;
                }
            }
        }
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(find(i));
        }
        return set.size();
    }
    public int find(int x){
        if(parent[x]==x)
           return x;
        return find(parent[x]);
    }
}