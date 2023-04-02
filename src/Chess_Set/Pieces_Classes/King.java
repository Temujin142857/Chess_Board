package Chess_Set.Pieces_Classes;

import Chess_Set.Game;

import java.util.ArrayList;

public class King implements Piece {
    boolean hasMoved=false;
    private String name;
    private int[] location;
    private ArrayList<int[]> possibleMoves;
    private ArrayList<int[]> blockedMoves;

    public King(String name, int[] location){
        this.name=name;
        this.location=location;
    }

    /**
     * getters and setters
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean hasMoved() {
        return false;
    }

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

    @Override
    public ArrayList<int[]> getPossibleMoves() {
        return possibleMoves;
    }

    @Override
    public ArrayList<int[]> getBlockedMoves() {
        return blockedMoves;
    }

    /**
     * finds if a move is valid using the horizontal & vertical shift
     * @param horizontal_shift horizontal shift trying to be applied.
     * @param vertical_shift vertical shift trying to be applied.
     * @param board dictionary of the board.
     * @returns if a move is valid.
     */
    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, Game board, boolean isCapturing) {
        //basic move
        if(Math.abs(horizontal_shift)<=1&&Math.abs(vertical_shift)<=1&&board.wouldBeCheck(this.location,location)){
            return true;
        }

        //castling
        if(!(Math.abs(horizontal_shift)==2)||!(vertical_shift==0)){return false;}//makes sure castling is going to a valid square
        if(((Math.signum(horizontal_shift)==1&&!board.at(7,location[1]).hasMoved())||(Integer.signum(horizontal_shift)==-1&&!board.at(0,location[1]).hasMoved()))&&!hasMoved){
            for (int i = location[0]+Integer.signum(horizontal_shift); i!=location[0]+horizontal_shift+Integer.signum(horizontal_shift); i+=Integer.signum(horizontal_shift)) {
                if (!board.isEmpty(i, location[1])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean canMove(int[] location, Game board){
        return canMove(location[0]-this.location[0],location[1]-this.location[1],board,true);
    }

    @Override
    public void updatePossibleMoves(Game board){
        possibleMoves = new ArrayList<int[]>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMove(new int[]{i,j},board))possibleMoves.add(new int[]{i,j});
            }
        }
    }

    @Override
    public void updateBlockedMoves(Game board){
        blockedMoves=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMove(new int[]{i,j},board)&&(board.wouldBeCheck(location,new int[]{i,j})||board.at(new int[]{i,j}).getName().charAt(0)==name.charAt(0)))blockedMoves.add(new int[]{i,j});
            }
        }
    }
}
