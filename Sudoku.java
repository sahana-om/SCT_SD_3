public class Sudoku {
    public static void main(String[] args) {
        int[][] board = {
                {0,0,4,0,0,3,0,7,0},
                {0,8,0,0,7,0,0,0,9},
                {6,0,0,0,0,0,5,0,0},
                {0,0,0,6,0,0,0,0,2},
                {0,3,0,0,9,0,0,4,0},
                {7,0,0,0,0,1,0,0,0},
                {0,0,2,0,0,0,0,0,6},
                {8,0,0,0,5,0,0,2,0},
                {0,6,0,1,0,0,3,0,0}
        };

        if(solveSudoku(board)){
            printBoard(board);
        } else {
            System.out.println("No Solution Exists");
        }
    }
    static boolean solveSudoku(int[][] board){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++){
                if(board[i][j]==0){
                    for(int num=1;num<=9;num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isValid(int[][] board, int row, int col, int num){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num)
                return false;
        }
        for(int i = 0; i < 9; i++){
            if(board[i][col] == num)
                return false;
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[startRow + i][startCol + j] == num)
                    return false;
            }
        }
        return true;
    }
    static void printBoard(int[][] board){
        for(int i = 0; i < 9; i++){
            if(i % 3 == 0 && i != 0)
                System.out.println("---------------------");
            for(int j = 0; j < 9; j++){
                if(j % 3 == 0 && j != 0)
                    System.out.print("| ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Sudoku Solved Successfully!\n");
    }

}
