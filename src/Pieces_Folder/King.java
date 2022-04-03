package Pieces_Folder;

import java.util.HashMap;

public class King implements Piece {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public String[] getVision(String location,HashMap<String,Piece> board) {
        return new String[0];
    }

    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, String location, HashMap<String, Piece> board, boolean x) {
        if(Math.abs(horizontal_shift)<=1&& Math.abs(vertical_shift)<=1){return true;}
        return false;
    }
}
