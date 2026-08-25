class Solution {
    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            long first = q.peek().index;
            long last = first;

            for(int i=0; i<size; i++) {
                Pair curr = q.poll();
                TreeNode node = curr.node;
                long index = curr.index;

                index = index-first;
                last = index;

                if(node.left != null) {
                    q.offer(new Pair(node.left, 2*index+1));
                }
                if(node.right != null) {
                    q.offer(new Pair(node.right, 2*index+2));
                }
            }

            int width = (int)(last+1);
            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}