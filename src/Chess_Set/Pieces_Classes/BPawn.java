package Chess_Set.Pieces_Classes;

import Chess_Set.Board;

import java.util.ArrayList;

public class BPawn implements Piece {
    private boolean hasMoved=false;
    String name;
    private int[] location;
    private ArrayList<int[]> possibleMoves;
    private ArrayList<int[]> blockedMoves;

    public BPawn(String name, int[] location){
        this.name=name;
        this.location=location;
    }

    /**
     * checks if the move is legal
     * @param horizontal_shift the horizontal move desired
     * @param vertical_shift the vertical move desired
     * @param board the dictionary of the board
     * @param isCapturing
     * @return if the move is legal
     */
    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, Board board, boolean isCapturing) {
        if(isCapturing&&Math.abs(horizontal_shift)==1&&vertical_shift==-1){return true;}//handles en passant as well
        if(!isCapturing&&location[1]==6&&horizontal_shift==0&&vertical_shift==-2&&board.isEmpty(location[0],5)&& board.isEmpty(location[0],4)){return true;}
        if(!isCapturing&&horizontal_shift==0&&vertical_shift==-1&&board.isEmpty(location[0],location[1]-1)){return true;}
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
    public void updateBlockedMoves(Board board){
        blockedMoves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isBlockedMove(new int[]{i,j},board))blockedMoves.add(new int[]{i,j});
            }
        }
    }

    private boolean isBlockedMove(int horizontal_shift, int vertical_shift, Board board) {
        if(Math.abs(horizontal_shift)==1&&vertical_shift==-1){return true;}
        if(location[1]==6&&horizontal_shift==0&&vertical_shift==-2&&!board.isEmpty(location[0],7)){return true;}
        if(horizontal_shift==0&&vertical_shift==-1&&!board.isEmpty(location[0],location[1]-1)){return true;}
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

    @Override
    public void setHasMoved(boolean hasMoved){
        this.hasMoved=hasMoved;
    }

    @Override
    public int[] getLocation(){
        return this.location;
    }

    @Override
    public void setLocation(int[] location){
        System.arraycopy(location, 0, this.location, 0, location.length);
    }

    @Override
    public ArrayList<int[]> getBlockedMoves() {
        return blockedMoves;
    }

    @Override
    public ArrayList<int[]> getPossibleMoves() {
        return possibleMoves;
    }

}
