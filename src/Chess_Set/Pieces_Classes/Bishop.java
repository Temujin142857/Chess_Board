package Chess_Set.Pieces_Classes;

import Chess_Set.Board;


public class Bishop implements Piece {
    private String name;
    private int[] location;

    public Bishop(String name, int[] location){
        this.name=name;
        this.location=location;
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

    @Override
    public void setHasMoved(boolean value) {

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
    public boolean canMove(int horizontal_shift, int vertical_shift, int[] location, Board board, boolean isCapturing) {
        if(Math.abs(horizontal_shift)!=Math.abs(vertical_shift)){return false;}
        int total_shift=1;
        while (total_shift<vertical_shift){
            if(!board.isEmpty(location[0]+(total_shift*Integer.signum(horizontal_shift)),location[1]+(total_shift*Integer.signum(vertical_shift)))){return false;}
            total_shift++;
        }
        setLocation(new int[] {location[0]+horizontal_shift,location[1]+vertical_shift});
        return true;
    }

    @Override
    public boolean canMove(int[] location, Board board){
        return canMove(location[0]-this.location[0],location[1]-this.location[1],location,board,true);
    }

    @Override
    public boolean hasMoved() {
        return true;
    }

    @Override
    public int[] getLocation(){
        return this.location;
    }

    @Override
    public void setLocation(int[] location){
        for (int i = 0; i < location.length; i++) {
            this.location[i]=location[i];
        }
    }
}
