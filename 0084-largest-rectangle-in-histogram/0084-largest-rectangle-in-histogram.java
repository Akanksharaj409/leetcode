class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] rightSm = new int[n];
        int[] leftSm = new int[n];

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()) {
                rightSm[i] = n;
            } else {
                rightSm[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()) {
                leftSm[i] = -1;
            } else {
                leftSm[i] = st.peek();
            }
            st.push(i);
        }

        int ans = 0;
    
        for(int i=0; i<heights.length; i++) {
            int width = rightSm[i]-leftSm[i]-1;
            int area = heights[i] * width;
            ans = Math.max(area, ans);
        }
        return ans;
    }
}