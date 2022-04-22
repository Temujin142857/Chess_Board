package Pieces_Folder;

import java.util.HashMap;

public class BPawn implements Piece {
    boolean hasMoved=false;
    int ascii_value_of_a=97;
    String name;

    public BPawn(String name){
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
 * gets the vision of a BPawn
 * @param location location of desired pawn
 * @param board dictionary of pawn
 * @return a stringArray that contains all the possible moves of a pawn
 */
    @Override
    public String[] getVision(String location,HashMap<String,Piece> board) {
        String diagonal_left=((location.charAt(0)+1-ascii_value_of_a)+'0')+String.valueOf(location.charAt(1)-1);
        String up=((location.charAt(0)+1-ascii_value_of_a)+'0')+String.valueOf(location.charAt(1)-1);
        String diagonal_right=((location.charAt(0)+1-ascii_value_of_a)+'0')+String.valueOf(location.charAt(1)-1);
        String[] moves={,"",""};
        return moves;
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
    public boolean canMove(int horizontal_shift, int vertical_shift, String location, HashMap<String, Piece> board, boolean isCapturing) {
        if(isCapturing&&Math.abs(horizontal_shift)==1&&vertical_shift==1){return true;}
        if(!isCapturing&&!hasMoved&&horizontal_shift==0&&vertical_shift==2){return true;}
        if(!isCapturing&&horizontal_shift==0&&vertical_shift==1){return true;}
        return false;
    }
}
