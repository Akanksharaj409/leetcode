
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = 1000000007L;
        int[] bits = new int[31];

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);

            for (int b = 0; b < 31; b++) {
                if ((num & (1 << b)) != 0) {
                    bits[b]++;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int b = 30; b >= 0; b--) {
                if (bits[b] > 0) {
                    num |= (1L << b);
                    bits[b]--;
                }
            }

            ans = (ans + num * num) % mod;
        }

        return (int) ans;
    }
}
