class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0, maxSum = 0, prevRun = -1;
        int i = 0;
        while(i < n) {
            if(s.charAt(i) == '1') {
                ones++;
                i++;
            } else {
                int curr = 0;
                while(i<n && s.charAt(i) == '0') {
                    curr++;
                    i++;
                }
                if(prevRun > 0) {
                    maxSum = Math.max(maxSum, prevRun+curr);
                }
                prevRun = curr;
            }
        }

        return ones + maxSum;
    }
}