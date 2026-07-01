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
    public static boolean isSymmetric(TreeNode root) {
    if (root == null)
    return true;
    Queue<TreeNode>queue=new LinkedList<>();
    if(root!=null){
        queue.offer(root);
    }
    while(!queue.isEmpty()){
        List<Integer>list=new ArrayList<>();
        int size=queue.size();
        for(int i=0;i<size;i++){
            TreeNode cur=queue.poll();
            if(cur!=null){
               list.add(cur.val);
               queue.offer(cur.left);
               queue.offer(cur.right);
            }  
            else
            list.add(null);
        
        }
        if(!check(list)){
           return false; 
        }
    }
    return true;
    }
    public static boolean check(List<Integer>list){
        int i=0,j=list.size()-1;
        while(i<j){
            if(Objects.equals(list.get(i),list.get(j))){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}