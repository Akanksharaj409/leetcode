class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        while(i<n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;
        if(i<n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if(s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        long res = 0;
        while(i<n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i)-'0';
            res = res*10 + digit;

            if(sign * res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if(sign * res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)(sign*res);
    }
}