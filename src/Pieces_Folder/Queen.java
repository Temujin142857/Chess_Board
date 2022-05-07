package Pieces_Folder;


public class Queen implements Piece {
    private String name;

    public Queen(String name){
        this.name=name;
    }

    /**
     * getter for name
     */
    @Override
    public String getName(){return name;}

/**
 * finds if a move is valid using the horizontal & vertical shift
 * @param horizontal_shift horizontal shift trying to be applied.
 * @param vertical_shift vertical shift trying to be applied.
 * @param location location of the pawn.
 * @param board dictionary of the board.
 * @param isCapturing checks if the piece is capturing or not.
 * @returns if a move is valid.
 */
    @Override
    public boolean canMove(int vertical_shift, int horizontal_shift, int[] location, Piece[][] board, boolean isCapturing) {
        if(Math.abs(horizontal_shift)==Math.abs(vertical_shift)) {
            int sign_of_vs = Integer.signum(vertical_shift);
            int sign_of_hs = Integer.signum(horizontal_shift);
            //for loop that stays between letter_coordinate and letter_coordinate+-vs or hs respectively
            for (int i = location[0] + sign_of_hs; i < Math.abs(horizontal_shift + location[0]) || i > (-1 * Math.abs(horizontal_shift)) + location[0]; i += 1 * sign_of_hs) {
                int j = location[1];
                j += 1 * sign_of_vs;
                if (!board[i][j].getName().equals("EMPTY")) {
                    return false;
                }
            }
        }
        else if(horizontal_shift == 0){
            for (int i = location[1]; i < 8 && i > 0; i+=Math.signum(vertical_shift)) {
                if(!board[location[0]][i].getName().equals("EMPTY")){
                    return false;
                }
            }
        }
        else if(vertical_shift == 0){
            for (int i = location[0]; i < 8 && i > 0; i+=Math.signum(horizontal_shift)) {
                if(!board[i][location[1]].getName().equals("EMPTY")){
                    return false;
                }
            }
        }
        else return false;

        return true;
    }

/**
 * takes care of return a string arrayList of the queen's vision
 * @param location initial space of the piece
 * @param board dictionary of the board
 * @return the vision of the queen piece !left to be done!
 */
    @Override
    public int[][] getVision(int[] location,Piece[][] board){
        return new String[0];
    }


}
