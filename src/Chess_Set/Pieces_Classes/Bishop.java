package Chess_Set.Pieces_Classes;

import Chess_Set.Board;

import java.util.ArrayList;


public class Bishop implements Piece {
    private String name;
    private int[] location;
    private ArrayList<int[]> possibleMoves;
    private ArrayList<int[]> blockedMoves;

    public Bishop(String name, int[] location){
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
        return true;
    }

    @Override
    public void setHasMoved(boolean hasMoved){}

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
     * with the class updated to also store it's own location, can now overload this method
     * to accept just the square it's being asked to move to, and the game board
     * @param horizontal_shift horizontal shift trying to be applied.
     * @param vertical_shift vertical shift trying to be applied.
     * @param board
     * @returns if a move is valid.
     */
    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, Board board, boolean isCapturing) {
        if(Math.abs(horizontal_shift)!=Math.abs(vertical_shift)){return false;}
        int total_shift=1;
        while (total_shift<Math.abs(vertical_shift)){
            System.out.println("square: "+(location[0]+(total_shift*Integer.signum(horizontal_shift)))+","+(location[1]+(total_shift*Integer.signum(vertical_shift))));
            System.out.println("piece on that square: "+board.at(location[0]+(total_shift*Integer.signum(horizontal_shift)),location[1]+(total_shift*Integer.signum(vertical_shift))));
            if(!board.isEmpty(location[0]+(total_shift*Integer.signum(horizontal_shift)),location[1]+(total_shift*Integer.signum(vertical_shift)))){
                System.out.println("failed");return false;}
            total_shift++;
        }
        System.out.println("true");
        return true;
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

    private boolean isBlockedMove(int horizontal_shift, int vertical_shift, Board board, boolean isCapturing) {
        if(Math.abs(horizontal_shift)!=Math.abs(vertical_shift)){return false;}
        int total_shift=1;
        while (total_shift<vertical_shift){
            if(!board.isEmpty(location[0]+(total_shift*Integer.signum(horizontal_shift)),location[1]+(total_shift*Integer.signum(vertical_shift)))){return true;}
            total_shift++;
        }
        return false;
    }

    private boolean isBlockedMove(int[] location, Board board){
        return isBlockedMove(location[0]-this.location[0],location[1]-this.location[1],board,true);
    }

}
