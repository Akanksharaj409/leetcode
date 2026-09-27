class Solution {
    public String reverseParentheses(String s) {
        StringBuilder curr = new StringBuilder();
        Stack<String> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(curr.toString());
                curr=new StringBuilder();
            } else if(ch == ')') {
                curr.reverse();
                String prev = st.pop();
                curr = new StringBuilder(prev+curr);
            } else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}