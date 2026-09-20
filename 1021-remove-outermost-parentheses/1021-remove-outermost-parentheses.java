class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int depth = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                if(depth>0) {
                    ans.append(c);
                }
                depth++;
            } else {
                depth--;
                if(depth>0) {
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }
}