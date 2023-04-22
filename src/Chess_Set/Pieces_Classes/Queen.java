package Chess_Set.Pieces_Classes;


import Chess_Set.Board;

import java.util.ArrayList;

public class Queen implements Piece {
    private String name;
    private int[] location;
    private ArrayList<int[]> possibleMoves;
    private ArrayList<int[]> blockedMoves;

    public Queen(String name, int[] location){
        this.name=name;
        this.location=location;
    }

    /**
     * getters and setters
     */
    @Override
    public String getName(){return name;}

    @Override
    public boolean hasMoved() {
        return true;
    }

    @Override
    public void setHasMoved(boolean value) {}

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
     * @param isCapturing checks if the piece is capturing or not.
     * @returns if a move is valid.
     */
    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, Board board, boolean isCapturing) {
        //bishop
        if(Math.abs(horizontal_shift)==Math.abs(vertical_shift)) {
            int total_shift=1;
            System.out.println(location[0]+","+location[1]);
            while (total_shift<Math.abs(vertical_shift)){
                if(!board.isEmpty(location[0]+(total_shift*Integer.signum(horizontal_shift)),location[1]+(total_shift*Integer.signum(vertical_shift)))){return false;}
                total_shift++;
            }
            return true;
        }
        //rook
        else if(horizontal_shift == 0){
            for (int i = location[1]+Integer.signum(vertical_shift); location[1]-Math.abs(vertical_shift) < i&&i < location[1]+Math.abs(vertical_shift); i+=Math.signum(vertical_shift)) {
                if(!board.isEmpty(location[0],i)){
                    System.out.println("y3o");
                    return false;
                }
            }
            return true;
        }
        else if(vertical_shift == 0){
            for (int i = location[0]+Integer.signum(horizontal_shift); location[0]-Math.abs(horizontal_shift) < i&&i < location[0]+Math.abs(horizontal_shift); i+=Math.signum(horizontal_shift)) {
                if(!board.isEmpty(i,location[1])){
                    System.out.println("yo2");
                    return false;
                }
            }

            return true;
        }
        System.out.println("yo1");
        return false;
    }

    /**
     * Overloads the previous method
     * @param location
     * @param board
     * @return
     */
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
        //bishop
        if(Math.abs(horizontal_shift)==Math.abs(vertical_shift)) {
            int total_shift=1;
            while (total_shift<vertical_shift){
                System.out.println("Meanwhile in bloced"+location[0]+","+location[1]);
                if(!board.isEmpty(location[0]+(total_shift*Integer.signum(horizontal_shift)),location[1]+(total_shift*Integer.signum(vertical_shift)))){return true;}
                total_shift++;
            }
        }
        //rook
        else if(horizontal_shift == 0){
            for (int i =location[1]+Integer.signum(vertical_shift); location[1]-Math.abs(vertical_shift) < i&&i < location[1]+Math.abs(vertical_shift); i+=Integer.signum(vertical_shift)) {
                if(!board.isEmpty(location[0],i)){
                    return true;
                }
            }
        }
        else if(vertical_shift == 0){
            for (int i = location[0]+Integer.signum(horizontal_shift); location[0]-Math.abs(horizontal_shift) < i&&i < location[0]+Math.abs(horizontal_shift); i+=Integer.signum(horizontal_shift)) {
                if(!board.isEmpty(i,location[1])){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Overloads the previous method
     * @param location
     * @param board
     * @return
     */
    private boolean isBlockedMove(int[] location, Board board){
        return isBlockedMove(location[0]-this.location[0],location[1]-this.location[1],board,true);
    }
}
