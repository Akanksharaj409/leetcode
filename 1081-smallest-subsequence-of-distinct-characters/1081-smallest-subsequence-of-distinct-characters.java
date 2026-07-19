class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int last[] = new int[26];
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            last[ch-'a'] = i;
        }

        Stack<Integer> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(set.contains(ch)) continue;
            
            while(!stack.isEmpty()) {
                char prev = s.charAt(stack.peek());
                if(prev > ch && last[prev-'a'] > i) {
                    stack.pop();
                    set.remove(prev);
                } else {
                    break;
                }
            }

            stack.push(i);
            set.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(s.charAt(stack.pop()));
        }
        sb.reverse();
        return sb.toString();
    }
}