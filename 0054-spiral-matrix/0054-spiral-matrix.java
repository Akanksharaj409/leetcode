class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int sr=0, sc=0, er=n-1, ec=m-1;
        while(sr<=er && sc<=ec) {
            for(int j=sc; j<=ec; j++) {
            result.add(matrix[sr][j]);
        }
        for(int i=sr+1; i<=er; i++) {
            result.add(matrix[i][ec]);
        }
        
        if(sr==er) {
            break;
        }
        for(int j=ec-1; j>=sc; j--) {
            result.add(matrix[er][j]);
        }
        if(sc==ec) {
            break;
        }
        for(int i=er-1; i>=sc+1; i--) {
            result.add(matrix[i][sc]);
        }
        sr++;
        sc++;
        er--;
        ec--;
        }
        return result;
    }
}