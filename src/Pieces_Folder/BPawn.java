package Pieces_Folder;

import java.util.HashMap;

public class BPawn implements Piece {
    boolean hasMoved=false;
    int ascii_value_of_a=97;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String[] getVision(String location,HashMap<String,Piece> board) {
        String diagonal_left=((location.charAt(0)+1-ascii_value_of_a)+'0')+String.valueOf(location.charAt(1)-1);
        String up=((location.charAt(0)+1-ascii_value_of_a)+'0')+String.valueOf(location.charAt(1)-1);
        String diagonal_right=((location.charAt(0)+1-ascii_value_of_a)+'0')+String.valueOf(location.charAt(1)-1);
        String[] moves={,"",""};
        return moves;
    }

    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, String location, HashMap<String, Piece> board, boolean isCapturing) {
        if(isCapturing&&Math.abs(horizontal_shift)==1&&vertical_shift==1){return true;}
        if(!isCapturing&&!hasMoved&&horizontal_shift==0&&vertical_shift==2){return true;}
        if(!isCapturing&&horizontal_shift==0&&vertical_shift==1){return true;}
        return false;
    }
}
