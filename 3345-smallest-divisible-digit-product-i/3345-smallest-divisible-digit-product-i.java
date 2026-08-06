class Solution {
    public int smallestNumber(int n, int t) {
        while(true) {
            int x = n;
            int prod = 1;
            while(x > 0) {
                int digit = x % 10;
                x = x/10;
                prod *= digit;
            }

            if(prod % t == 0) {
                return n;
            } 
            n++;
        }
    }
}