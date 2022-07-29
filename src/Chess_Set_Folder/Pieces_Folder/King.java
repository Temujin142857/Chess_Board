package Chess_Set_Folder.Pieces_Folder;

import Chess_Set_Folder.Board;

public class King implements Piece {
    private String name;

    public King(String name){
        this.name=name;
    }

    /**
     * getter for name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * takes care of return a string arrayList of the king's vision
     * @param location initial space of the piece
     * @param board dictionary of the board
     * @return the vision of the king piece !left to be done!
     */
    @Override
    public int[][] getVision(int[] location, Board board){return null;}

    /**
     * finds if a move is valid using the horizontal & vertical shift
     * @param horizontal_shift horizontal shift trying to be applied.
     * @param vertical_shift vertical shift trying to be applied.
     * @param location location of the pawn.
     * @param board dictionary of the board.
     * @param x checks if a pawn moved or not.
     * @returns if a move is valid.
     */
    @Override
    public boolean canMove(int vertical_shift, int horizontal_shift, int[] location, Board board, boolean isCapturing) {
        if(Math.abs(horizontal_shift)<=1&& Math.abs(vertical_shift)<=1){return true;}
        return false;
    }
}
