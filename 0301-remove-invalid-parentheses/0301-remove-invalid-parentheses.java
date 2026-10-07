class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                String current = queue.poll();

                if (isValid(current)) {
                    ans.add(current);
                    found = true;
                }

                if (found) {
                    continue;
                }

                for (int i = 0; i < current.length(); i++) {
                    if (current.charAt(i) != '(' && current.charAt(i) != ')') {
                        continue;
                    }

                    String next = current.substring(0, i) + current.substring(i + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            if (found) {
                break;
            }
        }

        return ans;
    }

    public boolean isValid(String s) {
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}