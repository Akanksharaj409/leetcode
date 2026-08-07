class Solution {
    public long findMaxContribution(int[] nums) {
        int n = nums.length;
        int prevGr[] = new int[n];
        int nextGr[] = new int[n];
        Stack<Integer> st = new Stack<>();

        //prev greater
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                prevGr[i] = -1;
            } else {
                prevGr[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();

        //next greater
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                nextGr[i] = n;
            } else {
                nextGr[i] = st.peek();
            }
            st.push(i);
        }

        long sum = 0;
        for(int i=0; i<n; i++) {
            int left = i - prevGr[i];
            int right = nextGr[i] - i;

            sum += 1L*nums[i]*left*right;
        }
        return sum;
    }

    public long findMinContribution(int[] nums) {
        int n = nums.length;
        int prevSm[] = new int[n];
        int nextSm[] = new int[n];
        Stack<Integer> st = new Stack<>();

        //prev greater
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                prevSm[i] = -1;
            } else {
                prevSm[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();

        //next greater
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                nextSm[i] = n;
            } else {
                nextSm[i] = st.peek();
            }
            st.push(i);
        }

        long sum = 0;
        for(int i=0; i<n; i++) {
            int left = i - prevSm[i];
            int right = nextSm[i] - i;

            sum += 1L*nums[i]*left*right;
        }
        return sum;
    }

    public long subArrayRanges(int[] nums) {
        long maxSum = findMaxContribution(nums);
        long minSum = findMinContribution(nums);

        return maxSum - minSum;
    }
}