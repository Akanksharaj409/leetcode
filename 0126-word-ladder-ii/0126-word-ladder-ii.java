class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> parents = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        distance.put(beginWord, 0);

        boolean found = false;

        while (!q.isEmpty() && !found) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String word = q.poll();
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) {
                            continue;
                        }

                        chars[j] = c;
                        String next = new String(chars);

                        if (!words.contains(next)) {
                            continue;
                        }

                        int newDistance = distance.get(word) + 1;

                        if (!distance.containsKey(next)) {
                            distance.put(next, newDistance);
                            q.offer(next);

                            parents.put(next, new ArrayList<>());
                            parents.get(next).add(word);
                        } else if (distance.get(next) == newDistance) {
                            parents.get(next).add(word);
                        }

                        if (next.equals(endWord)) {
                            found = true;
                        }
                    }

                    chars[j] = original;
                }
            }
        }

        if (!distance.containsKey(endWord)) {
            return result;
        }

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, parents, path, result);

        return result;
    }

    private void dfs(String word, String beginWord,
                     Map<String, List<String>> parents,
                     List<String> path,
                     List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> sequence = new ArrayList<>(path);
            Collections.reverse(sequence);
            result.add(sequence);
            return;
        }

        for (String parent : parents.get(word)) {
            path.add(parent);

            dfs(parent, beginWord, parents, path, result);

            path.remove(path.size() - 1);
        }
    }
}