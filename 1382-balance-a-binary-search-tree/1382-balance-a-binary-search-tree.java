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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        inorder(root,result);
        return buildgraph(result,0,result.size()-1);
    }
    public void inorder(TreeNode root,List<Integer>result){
        if(root!=null){
            inorder(root.left,result);
            result.add(root.val);
            inorder(root.right,result);
    }}
    public TreeNode buildgraph(List<Integer>result,int start,int end){
        if(start>end) return null;
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(result.get(mid));
        root.left=buildgraph(result,start,mid-1);
        root.right=buildgraph(result,mid+1,end);
        return root;
    }
}