package Pieces_Folder;

import java.util.ArrayList;


public class Bishop implements Piece {
    private String name;

    public Bishop(String name){
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
 * unfinished
 * gives the vision of a bishop
 * @param location location of the piece
 * @param board dictionary of the board
 * @return vision of the piece
 */
    @Override
    public int[][] getVision(int[] location,Piece[][] board){
        ArrayList<String> moves=new ArrayList<>();
        String CheckLoc=location.;
        while(board.containsKey(CheckLoc)) {
            
        }
        return  moves.toArray(new String[0]);
    }



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
        if(Math.abs(horizontal_shift)!=Math.abs(vertical_shift)){return false;}
        int sign_of_vs=Integer.signum(vertical_shift);
        int sign_of_hs=Integer.signum(horizontal_shift);
        //for loop that stays between letter_coordinate and letter_coordinate+-vs or hs respectively
        for (int i = location[0]+sign_of_hs; i < Math.abs(horizontal_shift+location[0])||i>(-1*Math.abs(horizontal_shift))+location[0]; i+=1*sign_of_hs) {
            int j=location[1]; j+=1*sign_of_vs;
            if(!board[i][j].getName().equals("EMPTY")){return false;}
        }
        return true;
    }
}
