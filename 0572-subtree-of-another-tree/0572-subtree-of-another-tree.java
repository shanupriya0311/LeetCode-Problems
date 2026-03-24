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
    boolean result=false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        if(root.val==subRoot.val && check(root,subRoot)){
            return true;
        }
        
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    public boolean check(TreeNode node,TreeNode subroot){
        if(subroot==null && node==null){
            return true;
        }
         if(subroot==null || node==null){
            return false;
        }
        if(node.val==subroot.val){
            return check(node.left,subroot.left) && check(node.right,subroot. right);
        }
        return false;  
    }
}