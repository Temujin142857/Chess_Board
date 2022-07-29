package Chess_Set_Folder.Pieces_Folder;

import Chess_Set_Folder.Board;


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
    public int[][] getVision(int[] location, Board board){
        return null;
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
    public boolean canMove(int vertical_shift, int horizontal_shift, int[] location, Board board, boolean isCapturing) {
        if(Math.abs(horizontal_shift)!=Math.abs(vertical_shift)){return false;}
        int sign_of_vs=Integer.signum(vertical_shift);
        int sign_of_hs=Integer.signum(horizontal_shift);
        int total_shift=1;
        while (total_shift<vertical_shift){
            if(!board.isEmpty(location[0]+(total_shift*sign_of_hs),location[1]+(total_shift*sign_of_vs))){return false;}
            total_shift++;
        }
        return true;
    }
}
