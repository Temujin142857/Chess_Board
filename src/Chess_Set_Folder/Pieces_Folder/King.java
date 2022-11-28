package Chess_Set_Folder.Pieces_Folder;

import Chess_Set_Folder.Board;

public class King implements Piece {
    boolean hasMoved=false;
    private String name;
    private int[] location;

    public King(String name, int[] location){
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
     * takes care of return a string arrayList of the king's vision
     * @param location initial space of the piece
     * @param board dictionary of the board
     * @return the vision of the king piece !left to be done!
     */
    @Override
    public int[][] getVision(int[] location, Board board){
        int[][] vision=new int[8][1];
        for (int i = 0; i < 8; i++) {

        }
        return null;
    }

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
        if(Math.abs(horizontal_shift)<=1&& Math.abs(vertical_shift)<=1){return true;}
        System.out.println(board.at((int) (location[0]+horizontal_shift+Math.signum(horizontal_shift)),location[1]+vertical_shift).hasMoved());
        System.out.println(!hasMoved);
        if(!board.at((int) (location[0]+horizontal_shift+Math.signum(horizontal_shift)),location[1]+vertical_shift).hasMoved()&&!hasMoved){
            for (int i = location[0]; i!=location[0]+horizontal_shift+Math.signum(horizontal_shift); i+=Math.signum(horizontal_shift)) {
                if (!board.isEmpty(i, location[1])) {
                    return false;
                }
            }
            hasMoved=true;
            this.location=new int[]{location[0]+horizontal_shift,location[1]+vertical_shift};
            return true;
        }
        return false;
    }

    @Override
    public boolean canMove(int[] location, Board board){
        return canMove(this.location[1]-location[1],this.location[0]-location[0],location,board,true);
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

}
