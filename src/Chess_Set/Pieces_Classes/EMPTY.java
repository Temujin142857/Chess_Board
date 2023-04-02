package Chess_Set.Pieces_Classes;

import Chess_Set.Game;

import java.util.ArrayList;

/**
 * represents an empty piece, so every propriety is basically null.
 */
public class EMPTY implements Piece {
    private String name;
    private int[] location;
    private ArrayList<int[]> possibleMoves;
    private ArrayList<int[]> blockedMoves;

    public EMPTY(String name, int[] location){
        this.name=name;
        this.location=location;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean canMove(int vertical_shift, int horizontal_shift, Game board, boolean isCapturing) {
        return false;
    }

    @Override
    public boolean canMove(int[] location, Game board){
        return canMove(this.location[1]-location[1],this.location[0]-location[0],board,true);
    }

    @Override
    public boolean hasMoved() {
        System.out.println("why");
        return true;
    }

    @Override
    public void setHasMoved(boolean value) {

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

    @Override
    public ArrayList<int[]> getPossibleMoves() {
        return null;
    }

    @Override
    public void updatePossibleMoves(Game board){

    }

    @Override
    public ArrayList<int[]> getBlockedMoves() {
        return blockedMoves;
    }

    @Override
    public void updateBlockedMoves(Game board) {

    }
}
