package Pieces_Folder;

import java.util.ArrayList;
import java.util.HashMap;

public class Bishop implements Piece {
    int ascii_value_of_a=97;
    String[] letters= LETTERS.getLETTERS();

    @Override
    public String getName() {
        return null;
    }


    @Override
    public String[] getVision(String location,HashMap<String,Piece> board) {
        ArrayList<String> moves=new ArrayList<>();
        String square_being_checked=letters[location.charAt(0)+1]+(location.charAt(1));
        while (board.containsKey(square_being_checked)){


            if(board.get(square_being_checked).getName().equals("EMPTY")){moves.add(square_being_checked);}

        }
        return  moves.toArray(new String[0]);
    }




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
