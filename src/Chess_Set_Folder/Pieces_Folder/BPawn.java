package Chess_Set_Folder.Pieces_Folder;

import Chess_Set_Folder.Board;

public class BPawn implements Piece {
    private boolean hasMoved;
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
    public boolean canMove(int vertical_shift, int horizontal_shift, int[] location, Board board, boolean isCapturing) {
        if(isCapturing&&Math.abs(horizontal_shift)==1&&vertical_shift==1){return true;}
        if(!isCapturing&&location[0]==6&&horizontal_shift==0&&vertical_shift==2){return true;}
        if(!isCapturing&&horizontal_shift==0&&vertical_shift==1){return true;}
        return false;
    }

    @Override
    public boolean canMove(int[] location, Board board){
        return canMove(this.location[1]-location[1],this.location[0]-location[0],location,board,true);
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
