class Solution {
    boolean[][] bool;
    int row,col;
    public void gameOfLife(int[][] board) {
        row = board.length; col = board[0].length;
        bool = new boolean[row][col];
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(board[i][j] == 1) bool[i][j] = true;
            }
        }
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                board[i][j] = dfs(i,j);
            }
        }
    }
    
    public int dfs(int i, int j){
        int count = 0;
        if(i > 0 && bool[i-1][j]) ++count;
        if(i > 0 && j < col-1 && bool[i-1][j+1]) ++count;
        if(i > 0 && j > 0 && bool[i-1][j-1]) ++count;
        if(j > 0 && bool[i][j-1]) ++count;
        if(j > 0 && i < row-1 && bool[i+1][j-1]) ++count;
        if(i < row-1 && bool[i+1][j]) ++count;
        if(i < row-1 && j < col-1 && bool[i+1][j+1]) ++count;
        if(j < col-1 && bool[i][j+1]) ++count;
        
        if(bool[i][j]){
            return (count == 2 || count == 3) ? 1 : 0;
        }else{
            return count == 3 ? 1 : 0;
        }
       // return count > 2 ? 1: 0;
    }
}
