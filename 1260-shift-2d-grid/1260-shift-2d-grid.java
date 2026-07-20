class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m*n;

        int temp[] = new int[size];
        int idx = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                temp[idx++] = grid[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        idx = 0;

        for(int i=0; i<m; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<n; j++) {
                int ind = ((idx-k)%size + size) % size;
                int val = temp[ind];
                idx++;
                list.add(val);
            }
            ans.add(list);
        }

        return ans;
    }
}