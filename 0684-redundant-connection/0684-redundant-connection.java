class Solution {
       int[] parent;
       int[] result=new int[2];
    public int[] findRedundantConnection(int[][] edges) {
        int v=0;
        for(int i=0;i<edges.length;i++){
            if(v<edges[i][0]){
                v=edges[i][0];
            }
            if(v<edges[i][1]){
                v=edges[i][1];
            }
        }
        parent=new int[v+1];
        for(int i=1;i<=v;i++){
            parent[i]=i;
        }
        for(int i=0;i<edges.length;i++){
           if(union(edges[i][0],edges[i][1])){
              break;
           }
        }
        return result;
    }
    public int find(int x){
       if(parent[x]==x){
        return x;
       }
       return find(parent[x]);
    }
    public boolean union(int s,int d){
        int roots=find(s);
        int rootd=find(d);
        if(roots==rootd){
            result[0]=s;
            result[1]=d;
            return true;
        }
        else{
            parent[rootd]=roots;
            return false;
        }
    }
}