import java.util.Arrays;

public class Queen {

    public static boolean solve(int board[][], int col){

        //Base Case
        if(col >= board.length){
            return  true;
        }

        for(int row = 0; row < board.length; row++){

            //Check if queen can be placed
            if(canPlace(board, row, col)){

                //Places a queen
                board[row][col] = 1;

                //Recursion to move on to next space
                if(solve(board, col + 1)){
                    return true;
                }
                board[row][col] = 0;
            }

        }
        return false;
    }

    public static boolean canPlace(int[][] board, int row, int col) {


        return isRowSafe(board, row, col) && isUpperLeftSafe(board, row, col)
                && isLowerLeftSafe(board, row, col);
    }
    private static boolean isLowerLeftSafe(int[][] board, int row, int col) {

        //Checks to see if there are any queens in lower left spaces
        for (int i = row, j = col; i < board.length && j >= 0 ; i++, j--) {
            if (board[i][j]==1){
                return false;
            }
        }
        return true;
    }
    private static boolean isUpperLeftSafe(int[][] board, int row, int col) {

        //Checks to see if there are any queens in upper left spaces
        for (int i = row, j = col; j >=0 && i>=0 && j<board.length; i--,j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRowSafe ( int[][] board, int row, int col){

        //Checks to see if there are any queens in the row spaces
        for (int i = col; i >= 0; i--){
            if (board[row][i] == 1){
                return false;
            }
        }
        return true;
    }
/*
   public static void main(String args[]){

       //create board
       int board[][] = new int[8][8];
       solve(board, 0);

       for(int[]row: board){
           System.out.println(Arrays.toString(row));

       }
   }
*/

}

