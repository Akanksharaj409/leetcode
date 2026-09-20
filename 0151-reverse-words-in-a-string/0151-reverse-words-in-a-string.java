class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String words[] = s.split("\\s+");
        int i=0, j=words.length-1;
        while(i<j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
        return String.join(" ", words);
    }
}