package Pieces_Folder;


import java.util.HashMap;

public class Knight implements Piece {
    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public String[] getVision(String location,HashMap<String,Piece> board) {
        return new String[0];
    }

    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, String location, HashMap<String, Piece> board, boolean x) {
        horizontal_shift=Math.abs(horizontal_shift);
        vertical_shift=Math.abs(vertical_shift);
        if(horizontal_shift==2&&vertical_shift==1){return true;}
        else if(horizontal_shift==1&&vertical_shift==2){return true;}
        return false;
    }
}
