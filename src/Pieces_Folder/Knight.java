package Pieces_Folder;


public class Knight implements Piece {
    private String name;

    public Knight(String name){
        this.name=name;
    }

    /**
     * getter for name
     */
    @Override
    public String getName() {
        return "Knight";
    }
/**
 * takes care of return a string arrayList of the knight's vision
 * @param location initial space of the piece
 * @param board dictionary of the board
 * @return the vision of the knight piece !left to be done!
 */
    @Override
    public int[][] getVision(int[] location,Piece[][] board){
/**
 * finds if a move is valid using the horizontal & vertical shift
 * @param horizontal_shift horizontal shift trying to be applied.
 * @param vertical_shift vertical shift trying to be applied.
 * @param location location of the pawn.
 * @param board dictionary of the board.
 * @returns if a move is valid.
 */
    @Override
    public boolean canMove(int vertical_shift, int horizontal_shift, int[] location, Piece[][] board, boolean isCapturing) {
        horizontal_shift=Math.abs(horizontal_shift);
        vertical_shift=Math.abs(vertical_shift);
        if(horizontal_shift==2&&vertical_shift==1||horizontal_shift==1&&vertical_shift==2){return true;}
        return false;
    }
}
