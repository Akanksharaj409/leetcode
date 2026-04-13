class Solution {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } 
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static Node root = new Node();

    public static int countChild(Node root) {
        int count = 0;
        for(int i=0; i<26; i++) {
            if(root.children[i] != null) {
                count++;
            }
        }
        return count;
    }

    public String longestCommonPrefix(String[] strs) {
        root = new Node();
        if(strs == null || strs.length == 0) {
            return "";
        }
        for(int i=0; i<strs.length; i++) {
            insert(strs[i]);
        }
        StringBuilder ans = new StringBuilder();
        Node curr = root;

        while(countChild(curr)==1 && curr.eow == false){
            for(int i=0; i<26; i++) {
                if(curr.children[i] != null) {
                    ans.append((char)(i+'a'));
                    curr = curr.children[i];
                    break;
                }
            }
        }
        return ans.toString();
    }
}
