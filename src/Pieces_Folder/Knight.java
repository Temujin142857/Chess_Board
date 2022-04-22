package Pieces_Folder;


import java.util.HashMap;

public class Knight implements Piece {
    private String name;

    public Knight(String name){
        this.name=name;
    }
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
    public boolean canMove(int horizontal_shift, int vertical_shift, String location, HashMap<String, Piece> board, boolean x) {
        horizontal_shift=Math.abs(horizontal_shift);
        vertical_shift=Math.abs(vertical_shift);
        if(horizontal_shift==2&&vertical_shift==1){return true;}
        else if(horizontal_shift==1&&vertical_shift==2){return true;}
        return false;
    }
}
