class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int steps = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                String word = q.poll();
                char[] chars = word.toCharArray();

                for(int j=0; j<chars.length; j++) {
                    char original = chars[j];
                    for(char ch='a'; ch<='z'; ch++) {
                        chars[j] = ch;
                        String nextWord = new String(chars);

                        if(nextWord.equals(endWord)) {
                            return steps+ 1;
                        }
                        if(set.contains(nextWord)) {
                            q.offer(nextWord);
                            set.remove(nextWord);
                        }
                    }
                    chars[j] = original;
                }
            }
            steps++;
        }
        return 0;
    }
}