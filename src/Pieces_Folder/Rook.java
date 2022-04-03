package Pieces_Folder;


import java.util.ArrayList;
import java.util.HashMap;

public class Rook implements Piece {
    String[] letters= LETTERS.getLETTERS();

    @Override
    public String getName() {
        return null;
    }


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

    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, String location, HashMap<String, Piece> board, boolean x) {
        return horizontal_shift == 0 || vertical_shift == 0;
    }
}
