class Solution {
    public int reverseDegree(String s) {
        int deg[] = new int[26];
        for(int i=0; i<26; i++) {
            deg[i] = 26-i;
        }
        int sum = 0;
        for(int i=1; i<=s.length(); i++) {
            sum += i*deg[s.charAt(i-1)-'a'];
        }
        return sum;
    }
}