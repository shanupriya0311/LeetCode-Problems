class Solution {
    List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        preorder(root);

        for (int i = 0; i < list.size()-1; i++) {
            TreeNode prev = list.get(i);
            TreeNode curr = list.get(i+1);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorder(TreeNode root) {
        if (root == null)
            return;

        list.add(root);
        preorder(root.left);
        preorder(root.right);
    }
}