class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);
        }

        int prod = 1;
        int i=1;
        
        while(true) {
            prod = i*k;
            if(!set.contains(prod)) {
                return prod;
            }
            i++;
        }
    }
}