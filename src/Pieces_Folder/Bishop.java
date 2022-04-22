package Pieces_Folder;

import java.util.ArrayList;
import java.util.HashMap;

public class Bishop implements Piece {
    int ascii_value_of_a=97;
    String[] letters= LETTERS.getLETTERS();
    String name;

    public Bishop(String name){
        this.name=name;
    }

/**
 * returns null because not relevant, to be set if  needs it
 */
    @Override
    public String getName() {
        return null;
    }

/**
 * gives the vision of a bishop pawn !Left to be done!
 * @param location location of the piece
 * @param board dictionary of the board
 * @return vision of the piece
 */
    @Override
    public String[] getVision(String location,HashMap<String,Piece> board) {
        ArrayList<String> moves=new ArrayList<>();
        //implement idea
        return  moves.toArray(new String[0]);
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
    public boolean canMove(int horizontal_shift, int vertical_shift, String location, HashMap<String,Piece> board, boolean x) {
        if(Math.abs(horizontal_shift)==Math.abs(vertical_shift)){
            int sign_of_vs=Integer.signum(vertical_shift);
            int sign_of_hs=Integer.signum(horizontal_shift);
            int letter_coordinate=location.charAt(0)-ascii_value_of_a;
            int number_coordinate=location.charAt(1);
            //for loop that stays between letter_coordinate and letter_coordinate+-vs or hs respectively
            for (int i = letter_coordinate+sign_of_hs; i < Math.abs(horizontal_shift+letter_coordinate)||i>(-1*Math.abs(horizontal_shift))+letter_coordinate; i+=1*sign_of_hs) {
                int j=number_coordinate; j+=1*sign_of_vs;
                if(!board.get(letters[i]+j).getName().equals("EMPTY")){return false;}
            }
        }
        if(Math.abs(horizontal_shift)!=Math.abs(vertical_shift)){return false;}
        return true;
    }
}
