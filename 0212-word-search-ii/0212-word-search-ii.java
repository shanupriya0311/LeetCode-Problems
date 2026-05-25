class TreeNode{
    Map<Character,TreeNode>map=new HashMap<>();
    String word=null;
}
class Solution {
    TreeNode root=new TreeNode();
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
     List<String>results=new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        int n=board.length;
        int m=board[0].length;
         boolean[][] visitb=new boolean[n][m];
        for(String i:words){
            insert(i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                  if(check(board[i][j]))
                   {
                        visitb[i][j]=true;
                        backtrack(board,i,j,root,visitb);
                          visitb[i][j]=false;
                            
                    }
                 }
            } 
         return results;
    }
    public void  backtrack(char[][] board,int r,int c,TreeNode root,boolean[][] visitb){
        char ch=board[r][c];
        if(!root.map.containsKey(ch))
           return;
        TreeNode nextnode=root.map.get(ch);
        if(nextnode.word!=null){
            results.add(nextnode.word);
            nextnode.word=null;
        }
        for(int i=0;i<4;i++){
            int nr=r+dir[i][0];
            int nc=c+dir[i][1];
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && !visitb[nr][nc]){
                visitb[nr][nc]=true;
                backtrack(board,nr,nc,nextnode,visitb);
                visitb[nr][nc]=false;
            }
        }
    }
    public void insert(String str){
        TreeNode node=root;
        for(Character i:str.toCharArray()){
            if(!node.map.containsKey(i)){
                node.map.put(i,new TreeNode());
            }
            node=node.map.get(i);
        }
        node.word=str;
    }
   public boolean check(Character i){
        TreeNode node=root;
        if(!node.map.containsKey(i)){
                return false;
        }
        return true;
        }
}