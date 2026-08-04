class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int left[] = new int[n];
        int right[] = new int[n];

        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                left[i] = i+1;
            } else {
                left[i] = i-st.peek();
            }
            st.push(i);
        }

        st.clear();
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                right[i] = n-i;
            } else {
                right[i] = st.peek() - i;
            }
            st.push(i);
        }
        
        long ans = 0;
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * left[i] * right[i];
            ans = (ans + contribution) % mod;
        }
        return (int)ans;
    }
}