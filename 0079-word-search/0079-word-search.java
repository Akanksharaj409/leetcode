class Solution {
    public boolean sol(char[][] board, char[] word, int i, int j, int idx) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] == '*' || board[i][j] != word[idx]) return false;

        if(idx == word.length-1) return true;
        char ch = board[i][j];
        board[i][j] = '*';
        boolean res = sol(board, word, i+1, j, idx+1) ||
            sol(board, word, i-1, j, idx+1) ||
            sol(board, word, i, j+1, idx+1) ||
            sol(board, word, i, j-1, idx+1);
        board[i][j] = ch;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        char[] word_arr = word.toCharArray();

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word_arr[0] && sol(board, word_arr, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}