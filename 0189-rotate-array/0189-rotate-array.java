class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        int s=0;
        int e=n-1;
        while(s<e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }

         s=0; e=k-1;
        while(s<e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }

         s=k; e=n-1;
        while(s<e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}