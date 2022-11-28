package Chess_Set_Folder.Pieces_Folder;


import Chess_Set_Folder.Board;

/**
 * represents an empty piece, so every propriety is basically null.
 */
public class EMPTY implements Piece {
    private String name;
    private int[] location;

    public EMPTY(String name, int[] location){
        this.name=name;
        this.location=location;
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

    @Override
    public boolean canMove(int[] location, Board board){
        return canMove(this.location[1]-location[1],this.location[0]-location[0],location,board,true);
    }

    @Override
    public boolean hasMoved() {
        return true;
    }
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

}
