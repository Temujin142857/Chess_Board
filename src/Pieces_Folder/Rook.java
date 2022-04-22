package Pieces_Folder;


import java.util.ArrayList;
import java.util.HashMap;

public class Rook implements Piece {
    String[] letters= LETTERS.getLETTERS();
    private String name;

    public Rook(String name){
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
 * takes care of return a string arrayList of the rook's vision
 * @param location initial space of the piece
 * @param board dictionary of the board
 * @return the vision of the rook piece
 */
    @Override
    public String[] getVision(String location,HashMap<String,Piece> board) {
        ArrayList<String> moves=new ArrayList<>();
        String square_being_checked;
        for (int i = 0; i < 8; i++) {
            square_being_checked=location.charAt(0)+String.valueOf(i+1);
            if (board.containsKey(square_being_checked)&&board.get(square_being_checked).getName().equals("EMPTY")){
                moves.add(square_being_checked);
            }
            square_being_checked=letters[i]+location.charAt(1);
            if (board.containsKey(square_being_checked)&&board.get(square_being_checked).getName().equals("EMPTY")){
                moves.add(square_being_checked);
            }
        }
        return moves.toArray(new String[0]);


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
        return horizontal_shift == 0 || vertical_shift == 0;
    }
}
