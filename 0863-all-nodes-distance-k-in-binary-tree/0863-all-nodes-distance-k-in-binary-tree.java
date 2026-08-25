/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParent(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int distance = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            if(distance == k) {
                List<Integer> res = new ArrayList<>();
                while(!q.isEmpty()) {
                    res.add(q.poll().val);
                }
                return res;
            }

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();

                if(node.left != null && !visited.contains(node.left)) {
                    q.offer(node.left);
                    visited.add(node.left);
                }

                if(node.right != null && !visited.contains(node.right)) {
                    q.offer(node.right);
                    visited.add(node.right);
                }
                
                if(parent.containsKey(node)) {
                    TreeNode p = parent.get(node);

                    if(!visited.contains(p)) {
                        q.offer(p);
                        visited.add(p);
                    }
                }
            }

            distance++;
        }

        return new ArrayList<>();
    }

    void buildParent(TreeNode node, TreeNode par) {
        if(node == null) {
            return;
        }

        if(par != null) {
            parent.put(node, par);
        }

        buildParent(node.left, node);
        buildParent(node.right, node);
    }
}