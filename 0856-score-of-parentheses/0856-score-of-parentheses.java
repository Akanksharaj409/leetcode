class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                st.push(0);
            } else {
                int inner = st.pop();
                int ans;
                if(inner == 0) {
                    ans = 1;
                } else {
                    ans = 2*inner;
                }
                st.push(st.pop() + ans);
            }
        }
        return st.peek();
    }
}