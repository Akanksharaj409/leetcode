class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int height[] = new int[cols];
        int maxArea = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            Stack<Integer> st = new Stack<>();

            for(int j=0; j<=cols; j++) {
                int current = (j == cols) ? 0 : height[j];

                while(!st.isEmpty() && height[st.peek()] > current) {
                    int h = height[st.pop()];
                    int width;
                    if(st.isEmpty()) {
                        width = j;
                    } else {
                        width = j - st.peek() - 1;
                    }

                    maxArea = Math.max(maxArea, h*width);
                }
                st.push(j);
            }

        }

        return maxArea;
    }
}