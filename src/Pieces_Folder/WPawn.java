package Pieces_Folder;


import java.util.HashMap;

public class WPawn implements Piece {
    boolean hasMoved=false;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String[] getVision(String location,HashMap<String,Piece> board) {
        return new String[0];
    }

    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, String location, HashMap<String, Piece> board, boolean isCapturing) {
        if(isCapturing&&Math.abs(horizontal_shift)==1&&vertical_shift==-1){return true;}
        if(!isCapturing&&!hasMoved&&horizontal_shift==0&&vertical_shift==-2){return true;}
        if(!isCapturing&&horizontal_shift==0&&vertical_shift==-1){return true;}
        return false;
    }
}
