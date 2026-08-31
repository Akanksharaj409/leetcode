/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    void serializeHelper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> q = new LinkedList<>();

        for(String value: values) {
            q.offer(value);
        }

        return deserializeHelper(q);
    }

    TreeNode deserializeHelper(Queue<String> q) {
        String value = q.poll();

        if(value.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserializeHelper(q);
        root.right = deserializeHelper(q);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));