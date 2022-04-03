package Pieces_Folder;

import java.util.HashMap;

public class Queen implements Piece {
    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, String location, HashMap<String, Piece> board, boolean x) {
        horizontal_shift=Math.abs(horizontal_shift);
        vertical_shift=Math.abs(vertical_shift);
        return horizontal_shift == 0 || vertical_shift == 0 || Math.abs(horizontal_shift)==Math.abs(vertical_shift);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String[] getVision(String location,HashMap<String,Piece> board) {
        return new String[0];
    }


}
