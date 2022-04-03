package Pieces_Folder;

import java.util.HashMap;

public class EMPTY implements Piece {
    @Override
    public String getName() {
        return "EMPTY";
    }

    @Override
    public String[] getVision(String location,HashMap<String,Piece> board) {
        return new String[0];
    }

    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, String location, HashMap<String, Piece> board, boolean x) {
        return false;
    }
}
