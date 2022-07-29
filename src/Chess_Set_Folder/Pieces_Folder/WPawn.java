package Chess_Set_Folder.Pieces_Folder;


import Chess_Set_Folder.Board;

public class WPawn implements Piece {
    boolean hasMoved=false;
    private String name;

    public WPawn(String name){
        this.name=name;
    }

    /**
     * getter for name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * takes care of return a string arrayList of a wpiece's vision
     * @param location initial space of the piece
     * @param board dictionary of the board
     * @return the vision of the wpawn piece !left to be done!
     */
    @Override
    public int[][] getVision(int[] location, Board board){return null;}

    /**
     * finds if a move is valid using the horizontal & vertical shift
     * @param horizontal_shift horizontal shift trying to be applied.
     * @param vertical_shift vertical shift trying to be applied.
     * @param location location of the pawn.
     * @param board dictionary of the board.
     * @returns if a move is valid.
     */
    @Override
    public boolean canMove(int vertical_shift, int horizontal_shift, int[] location, Board board, boolean isCapturing) {
        if(isCapturing&&Math.abs(horizontal_shift)==1&&vertical_shift==-1){return true;}
        if(!isCapturing&&!hasMoved&&horizontal_shift==0&&vertical_shift==-2){return true;}
        if(!isCapturing&&horizontal_shift==0&&vertical_shift==-1){return true;}
        return false;
    }
}
