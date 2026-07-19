class Solution {
    public void sol(String digits, Map<Character, String> map, List<String> ans, String curr, int idx) {
        if(idx == digits.length()) {
            ans.add(curr);
            return;
        }

        for(char c: map.get(digits.charAt(idx)).toCharArray()) {
            String temp = new String(curr);
            temp += c;
            sol(digits, map, ans, temp, idx+1);
        }
    }

    public Map<Character, String> getMap() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        return map;
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = getMap();
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        sol(digits, map, ans, "", 0);

        return ans;
    }
}