class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.get(ch) > 2) {
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            ans = Math.max(ans, i-left+1);
        }

        return ans;
    }
}