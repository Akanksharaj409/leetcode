
class Solution {
    TreeNode first = null;
    TreeNode sec = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = sec.val;
        sec.val = temp;
    }

    void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);

        if(prev != null && prev.val > root.val) {
            if(first == null) {
                first = prev;
            }
            sec = root;
        }
        prev = root;
        inorder(root.right);
    }
}