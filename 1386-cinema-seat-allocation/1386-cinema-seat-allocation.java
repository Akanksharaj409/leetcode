class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int seat[]: reservedSeats) {
            int row = seat[0];
            int s = seat[1];

            if(s >=2 && s<= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << s));
            }
        }

        int ans = (n - map.size()) * 2;

        for(int mask: map.values()) {
            boolean left = (mask & 0b00111100) == 0;
            boolean middle = (mask & 0b0011110000) == 0;
            boolean right = (mask & 0b1111000000) == 0;

            if(left && right) {
                ans += 2;
            } else if(left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}