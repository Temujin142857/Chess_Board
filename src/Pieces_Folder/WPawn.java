package Pieces_Folder;


import java.util.HashMap;

public class WPawn implements Piece {
    boolean hasMoved=false;
    private String name;

    public WPawn(String name){
        this.name=name;
    }
/**
 * returns null because not relevant, to be set if visual needs it
 */
    @Override
    public String getName() {
        return null;
    }
/**
 * takes care of return a string arrayList of a wpiece's vision
 * @param location initial space of the piece
 * @param board dictionary of the board
 * @return the vision of the wpawn piece !left to be done!
 */
    @Override
    public String[] getVision(String location,HashMap<String,Piece> board) {
        return new String[0];
    }
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
    public boolean canMove(int horizontal_shift, int vertical_shift, String location, HashMap<String, Piece> board, boolean isCapturing) {
        if(isCapturing&&Math.abs(horizontal_shift)==1&&vertical_shift==-1){return true;}
        if(!isCapturing&&!hasMoved&&horizontal_shift==0&&vertical_shift==-2){return true;}
        if(!isCapturing&&horizontal_shift==0&&vertical_shift==-1){return true;}
        return false;
    }
}
