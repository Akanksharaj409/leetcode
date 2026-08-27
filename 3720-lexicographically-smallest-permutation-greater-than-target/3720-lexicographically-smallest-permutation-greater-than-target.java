class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = target.toCharArray();

        for (int i = 0; i < n; i++) {
            int x = target.charAt(i) - 'a';

            if (freq[x] > 0) {
                freq[x]--;
            } else {
                for (int j = x + 1; j < 26; j++) {
                    if (freq[j] > 0) {
                        ans[i] = (char) ('a' + j);
                        freq[j]--;
                        fill(ans, i + 1, freq);
                        return new String(ans);
                    }
                }

                for (int p = i - 1; p >= 0; p--) {
                    freq[ans[p] - 'a']++;

                    int t = target.charAt(p) - 'a';

                    for (int j = t + 1; j < 26; j++) {
                        if (freq[j] > 0) {
                            ans[p] = (char) ('a' + j);
                            freq[j]--;
                            fill(ans, p + 1, freq);
                            return new String(ans);
                        }
                    }
                }

                return "";
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            freq[ans[i] - 'a']++;

            int t = target.charAt(i) - 'a';

            for (int j = t + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    ans[i] = (char) ('a' + j);
                    freq[j]--;
                    fill(ans, i + 1, freq);
                    return new String(ans);
                }
            }
        }

        return "";
    }

    private void fill(char[] ans, int start, int[] freq) {
        int k = start;

        for (int c = 0; c < 26; c++) {
            while (freq[c] > 0) {
                ans[k++] = (char) ('a' + c);
                freq[c]--;
            }
        }
    }
}