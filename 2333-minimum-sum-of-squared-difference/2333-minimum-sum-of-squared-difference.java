class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long operations = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long total = 0;

        for (int i = 0; i < n; i++) {
            total += diff[i];
        }

        if (operations >= total) {
            return 0;
        }

        int low = 0;
        int high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int i = 0; i < n; i++) {
                if (diff[i] > mid) {
                    needed += diff[i] - mid;
                }
            }

            if (needed <= operations) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int target = low;
        long remaining = operations;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (diff[i] > target) {
                remaining -= diff[i] - target;
                diff[i] = target;
            }
        }

        for (int i = 0; i < n; i++) {
            if (remaining > 0 && diff[i] > 0 && diff[i] == target) {
                diff[i]--;
                remaining--;
            }
            ans += (long) diff[i] * diff[i];
        }

        return ans;
    }
}