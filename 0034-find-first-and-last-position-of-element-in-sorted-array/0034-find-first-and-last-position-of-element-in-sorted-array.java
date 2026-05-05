class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurance(nums, target);
        int last = lastOccurance(nums, target);
        return new int[]{first, last};
    }

    public int firstOccurance(int[] nums, int target) {
        int ans = -1;
        int s=0, e = nums.length-1;
        while(s<=e) {
            int mid = (s+e)/2;
            if(nums[mid]==target) {
                ans = mid;
                e = mid-1;
            } else if(nums[mid]<target) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        return ans;
    }

    public int lastOccurance(int[] nums, int target) {
        int s=0, e = nums.length-1;
        int ans = -1;
        while(s<=e) {
            int mid = (s+e)/2;
            if(nums[mid]==target) {
                ans = mid;
                s = mid+1;
            } else if(nums[mid]<target) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        return ans;
    }
}