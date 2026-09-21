class Solution {
    public String countAndSay(int n) {
        String ans = "1";

        for(int k=1; k<n; k++) {
            StringBuilder sb = new StringBuilder();

            int i = 0;
            while(i<ans.length()) {
                char ch = ans.charAt(i);
                int count = 0;

                while(i<ans.length() && ans.charAt(i)==ch) {
                    count++;
                    i++;
                }

                sb.append(count);
                sb.append(ch);
            }
            ans = sb.toString();
        }
        return ans;
    }
}