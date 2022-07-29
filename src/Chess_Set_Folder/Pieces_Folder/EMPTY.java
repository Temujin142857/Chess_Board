package Chess_Set_Folder.Pieces_Folder;


import Chess_Set_Folder.Board;

/**
 * represents an empty piece, so every propriety is basically null.
 */
public class EMPTY implements Piece {
    private String name;

    public EMPTY(String name){
        this.name=name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int[][] getVision(int[] location, Board board) {
        return new int[0][];
    }


    @Override
    public boolean canMove(int vertical_shift, int horizontal_shift, int[] location, Board board, boolean isCapturing) {
        return false;
    }
}
