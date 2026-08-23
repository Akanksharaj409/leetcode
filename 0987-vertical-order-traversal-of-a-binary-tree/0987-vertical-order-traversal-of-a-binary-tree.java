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
    class NodeInfo {
        int row;
        int col;
        int val;

        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);

        Collections.sort(nodes, (a, b) -> {
            if(a.col != b.col)
                return a.col - b.col;
            if(a.row != b.row)
                return a.row - b.row;

            return a.val - b.val;
        });

        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for(NodeInfo node: nodes) {
            if(node.col != prevCol) {
                res.add(new ArrayList<>());
                prevCol = node.col;
            }
            res.get(res.size()-1).add(node.val);
        }
        return res;
    }

    public void dfs(TreeNode root, int row, int col, List<NodeInfo> nodes) {
        if(root == null) {
            return;
        }

        nodes.add(new NodeInfo(row, col, root.val));
        dfs(root.left, row+1, col-1, nodes);
        dfs(root.right, row+1, col+1, nodes);
    }
}