class Solution {
    List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        preorder(root);

        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);

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