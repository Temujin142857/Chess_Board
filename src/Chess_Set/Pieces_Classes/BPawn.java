package Chess_Set.Pieces_Classes;

import Chess_Set.Board;

public class BPawn implements Piece {
    private boolean hasMoved=false;
    String name;
    private int[] location;

    public BPawn(String name, int[] location){
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
     * gets the vision of a BPawn
     * @param location location of desired pawn
     * @param board dictionary of pawn
     * @return a stringArray that contains all the possible moves of a pawn
     */
    @Override
    public int[][] getVision(int[] location, Board board) {
        return null;
    }

    /**
     * checks if the move is legal
     * @param horizontal_shift the horizontal move desired
     * @param vertical_shift the vertical move desired
     * @param location location of the piece in question
     * @param board the dictionary of the board
     * @param isCapturing
     * @return if the move is legal
     */
    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, int[] location, Board board, boolean isCapturing) {
        if(isCapturing&&Math.abs(horizontal_shift)==1&&vertical_shift==-1){hasMoved=true;setLocation(new int[] {location[0]+horizontal_shift,location[1]+vertical_shift});return true;}
        if(!isCapturing&&location[1]==6&&horizontal_shift==0&&vertical_shift==-2){hasMoved=true;setLocation(new int[] {location[0]+horizontal_shift,location[1]+vertical_shift});return true;}
        if(!isCapturing&&horizontal_shift==0&&vertical_shift==-1){hasMoved=true;setLocation(new int[] {location[0]+horizontal_shift,location[1]+vertical_shift});return true;}
        setLocation(new int[] {location[0]+horizontal_shift,location[1]+vertical_shift});
        return false;
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
    public void setHasMoved(boolean value) {
        hasMoved=value;
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
