class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int left = check(root.left);
        int right = check(root.right);

        if (Math.abs(left - right) > 1)
            return false;
        return isBalanced(root.right) && isBalanced(root.left);
    }

    public int check(TreeNode root) {
        if (root == null)
            return 0;

        int left = check(root.left);
        int right = check(root.right);

        return Math.max(left, right) + 1;
    }
}