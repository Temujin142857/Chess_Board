package Chess_Set_Folder.Pieces_Folder;

import Chess_Set_Folder.Board;

public class BPawn implements Piece {
    String name;

    public BPawn(String name){
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
     * gets the vision of a BPawn
     * @param location location of desired pawn
     * @param board dictionary of pawn
     * @return a stringArray that contains all the possible moves of a pawn
     */
    @Override
    public int[][] getVision(int[] location, Board board) {
        return null;
    }

    /**
     * checks if the move is legal
     * @param horizontal_shift the horizontal move desired
     * @param vertical_shift the vertical move desired
     * @param location location of the piece in question
     * @param board the dictionary of the board
     * @param isCapturing
     * @return if the move is legal
     */
    @Override
    public boolean canMove(int vertical_shift, int horizontal_shift, int[] location, Board board, boolean isCapturing) {
        if(isCapturing&&Math.abs(horizontal_shift)==1&&vertical_shift==1){return true;}
        if(!isCapturing&&location[0]==6&&horizontal_shift==0&&vertical_shift==2){return true;}
        if(!isCapturing&&horizontal_shift==0&&vertical_shift==1){return true;}
        return false;
    }
}
