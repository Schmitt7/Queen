import java.util.Arrays;

public class Sudoku {

    //spot is the position from first space.
    static boolean solve(int[][] board, int spot) {


        //If spot is past the final empty space then print the completed board
        //Base Case
        if (spot >= 81) {
            for (int i = 0; i < 9; i++) {
                System.out.println(Arrays.toString(board[i]));
            }
            return true;
        }

        //If spot does not have a zero move on to next spot
        if (board[spot / 9][spot % 9] != 0)
            return solve(board, spot + 1);

            //If spot does have a zero then it checks what numbers will fit
        else {
            for (int i = 1; i < 10; i++) {


                if(CheckMove(board, i, spot / 9, spot % 9)) {
                    board[spot / 9][spot % 9] = i;

                    if (solve(board, spot + 1))
                        return true;

                    else board[spot / 9][spot % 9] = 0;
                }
            }
        }

        return false;
    }

    static boolean  CheckMove(int[][] board, int num, int row, int col) {

        //Method checks constraints required by sudoku rules


        //checks 3x3 box path
        int rowBox = row / 3;
        int colBox = col / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + (3 * rowBox)][j + (3 * colBox)] == num)
                    return false;
            }
        }

        //checks the rows path
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] == num)
                return false;
        }

        //checks columns path
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] == num)
                return false;
        }
        return true;
    }


    //Solves a sudoku board
    public static void main(String[] args) {

        //Starting sudoku board
        int[][] board = new int[][]{

                {5, 0, 2, 0, 0, 1, 0, 6, 7},
                {0, 3, 4, 0, 0, 9, 8, 0, 0},
                {0, 7, 0, 8, 5, 0, 3, 0, 1},
                {0, 9, 3, 2, 8, 0, 0, 7, 0},
                {6, 0, 0, 0, 0, 0, 5, 3, 4},
                {0, 1, 0, 4, 0, 0, 0, 0, 9},
                {0, 0, 7, 9, 1, 0, 0, 5, 2},
                {0, 0, 9, 7, 3, 6, 4, 1, 0},
                {8, 6, 0, 0, 0, 4, 0, 0, 0}
        };
        solve(board, 0);
    }



}

