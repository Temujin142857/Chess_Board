package Chess_Set.Pieces_Classes;


import Chess_Set.Board;

import java.util.ArrayList;

public class WPawn implements Piece {
    private boolean hasMoved=false;
    private String name;
    private int[] location;
    private ArrayList<int[]> possibleMoves;
    private ArrayList<int[]> blockedMoves;

    public WPawn(String name, int[] location){
        this.name=name;
        this.location=location;
    }

    /**
     * finds if a move is valid using the horizontal & vertical shift
     * @param horizontal_shift horizontal shift trying to be applied.
     * @param vertical_shift vertical shift trying to be applied.
     * @param board dictionary of the board.
     * @returns if a move is valid.
     */
    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, Board board, boolean isCapturing) {
        if(isCapturing&&Math.abs(horizontal_shift)==1&&vertical_shift==1){return true;}
        if(!isCapturing&&!hasMoved&&horizontal_shift==0&&vertical_shift==2&&board.isEmpty(location[0],3)&&board.isEmpty(location[0],2)){return true;}
        if(!isCapturing&&horizontal_shift==0&&vertical_shift==1&&board.isEmpty(location[0],location[1]+1)){return true;}
        return false;
    }

    @Override
    public boolean canMove(int[] location, Board board){
        return canMove(location[0]-this.location[0],location[1]-this.location[1],board,true);
    }

    @Override
    public void updatePossibleMoves(Board board){
        possibleMoves = new ArrayList<int[]>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMove(new int[]{i,j},board))possibleMoves.add(new int[]{i,j});
            }
        }
    }

    @Override
    public void updateBlockedMoves(Board board) {
        blockedMoves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isBlockedMove(new int[]{i,j},board))blockedMoves.add(new int[]{i,j});
            }
        }
    }

    private boolean isBlockedMove(int horizontal_shift, int vertical_shift, Board board) {
        if(Math.abs(horizontal_shift)==1&&vertical_shift==1){return true;}
        if(location[1]==6&&horizontal_shift==0&&vertical_shift==2&&!board.isEmpty(location[0],3)){return true;}
        if(horizontal_shift==0&&vertical_shift==1&&!board.isEmpty(location[0],location[1]+1)){return true;}
        return false;
    }

    private boolean isBlockedMove(int[] location, Board board){
        return isBlockedMove(location[0]-this.location[0],location[1]-this.location[1],board);
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
        return true;
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
}
