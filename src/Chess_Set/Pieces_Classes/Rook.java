package Chess_Set.Pieces_Classes;


import Chess_Set.Board;

public class Rook implements Piece {
    private boolean hasMoved=false;
    private String name;
    private int[] location;

    public Rook(String name, int[] location){
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
     * takes care of return a string arrayList of the rook's vision
     * @param location initial space of the piece
     * @param board dictionary of the board
     * @return the vision of the rook piece
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
     * @param isCapturing checks if the piece is capturing or not.
     * @returns if a move is valid.
     */
    @Override
    public boolean canMove(int horizontal_shift, int vertical_shift, int[] location, Board board, boolean isCapturing) {
        if(horizontal_shift == 0){
            for (int i =location[1]+Integer.signum(vertical_shift); location[1]-Math.abs(vertical_shift) < i&&i < location[1]+Math.abs(vertical_shift); i+=Integer.signum(vertical_shift)) {
                if(!board.isEmpty(location[0],i)){
                    return false;
                }
            }
        }
        else if(vertical_shift == 0){
            for (int i = location[0]+Integer.signum(horizontal_shift); location[0]-Math.abs(horizontal_shift) < i&&i < location[0]+Math.abs(horizontal_shift); i+=Integer.signum(horizontal_shift)) {
                if(!board.isEmpty(i,location[1])){
                    return false;
                }
            }
        }
        setLocation(new int[] {location[0]+horizontal_shift,location[1]+vertical_shift});
        return true;
    }

    @Override
    public boolean canMove(int[] location, Board board){
        return canMove(location[0]-this.location[0],location[1]-this.location[1],location,board,true);
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

    public boolean hasMoved() {
        System.out.println("good");
        return hasMoved;
    }
    public void setHasMoved(boolean value) {
        hasMoved=value;
    }
}
