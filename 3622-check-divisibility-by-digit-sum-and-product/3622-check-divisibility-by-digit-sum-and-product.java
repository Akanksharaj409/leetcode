class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int curr = n;

        while(curr>0) {
            int digit = curr % 10;
            sum += digit;
            prod *= digit;
            curr = curr / 10;
        }

        return (n % (sum + prod))== 0;
    }
}