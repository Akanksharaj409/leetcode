class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<num.length(); i++) {
            char dig = num.charAt(i);

            while(!st.isEmpty() && k>0 && st.peek() > dig) {
                st.pop();
                k--;
            }
            st.push(dig);
        }
        while(k>0) {
            st.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        res.reverse();

        int i=0;
        while(i<res.length() && res.charAt(i) == '0') {
            i++;
        }
        if(i == res.length()) {
            return "0";
        }

        return res.substring(i);
    }
}