package Chess_Set_Folder.Pieces_Folder;


import Chess_Set_Folder.Board;

public class Rook implements Piece {
    private String name;

    public Rook(String name){
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
    public boolean canMove(int vertical_shift, int horizontal_shift, int[] location, Board board, boolean isCapturing) {
        if(horizontal_shift == 0){
            for (int i = location[1]; i < 8 && i > 0; i+=Math.signum(vertical_shift)) {
                if(!board.isEmpty(location[0],i)){
                    return false;
                }
            }
        }
        else if(vertical_shift == 0){
            for (int i = location[0]; i < 8 && i > 0; i+=Math.signum(horizontal_shift)) {
                if(!!board.isEmpty(location[0],i)){
                    return false;
                }
            }
        }
        return true;
    }
}
