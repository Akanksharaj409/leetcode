class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public void inorder(TreeNode root) {
        if(root==null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }
}