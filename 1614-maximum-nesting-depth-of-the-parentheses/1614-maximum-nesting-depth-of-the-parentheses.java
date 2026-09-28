class Solution {
    public int maxDepth(String s) {
        int max = 0;
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<s.length()) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(ch);
            } else if(ch == ')') {
                int curr = st.size();
                max = Math.max(max, curr);
                st.pop();
            } 
            i++;
        }
        return max;
    }
}