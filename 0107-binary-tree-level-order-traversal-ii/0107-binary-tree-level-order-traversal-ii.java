/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>>list=new ArrayList<>();
    List<List<Integer>>result=new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root!=null)
         levelorder(root);
        return result;
    }
    public void levelorder(TreeNode root){
       Queue<TreeNode>q=new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
        List<Integer>lists=new ArrayList<>();
        int m=q.size();
        for(int i=0;i<m;i++){
            TreeNode t=q.poll();
            lists.add(t.val);
            if(t.left!=null){
                q.add(t.left);
            }
            if(t.right!=null){
                q.add(t.right);
            }
        }
        list.add(lists);
       }
       for(int i=list.size()-1;i>=0;i--){
          result.add(list.get(i));
       }
       return;
    }
}