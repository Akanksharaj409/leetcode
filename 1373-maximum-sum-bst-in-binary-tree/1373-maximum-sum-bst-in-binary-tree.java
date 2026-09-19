
class Solution {
    int maxSum = 0;
    class Info {
        boolean isBST;
        int min;
        int max;
        int sum;

        Info(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    public int maxSumBST(TreeNode root) {
        postorder(root);
        return maxSum;
    }

    Info postorder(TreeNode root) {
        if(root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Info left = postorder(root.left);
        Info right = postorder(root.right);

        if(left.isBST && right.isBST && left.max<root.val && root.val<right.min) {
            int sum = left.sum + root.val + right.sum;
            maxSum = Math.max(maxSum, sum);

            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);

            return new Info(true, min, max, sum);
        }
        return new Info(false, 0, 0, 0);
    }
}