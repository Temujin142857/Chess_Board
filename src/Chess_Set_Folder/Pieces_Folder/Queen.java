package Chess_Set_Folder.Pieces_Folder;


import Chess_Set_Folder.Board;

public class Queen implements Piece {
    private String name;
    private int[] location;

    public Queen(String name, int[] location){
        this.name=name;
        this.location=location;
    }

    /**
     * getter for name
     */
    @Override
    public String getName(){return name;}

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
        System.out.println("vertical Shift: "+(location[1]-vertical_shift));
        System.out.println("horizantal Shift:" +horizontal_shift);
        if(Math.abs(horizontal_shift)==Math.abs(vertical_shift)) {
            int sign_of_vs=Integer.signum(vertical_shift);
            int sign_of_hs=Integer.signum(horizontal_shift);
            int total_shift=1;
            while (total_shift<vertical_shift){
                if(!board.isEmpty(location[0]+(total_shift*sign_of_hs),location[1]+(total_shift*sign_of_vs))){return false;}
                total_shift++;
            }
        }
        else if(horizontal_shift == 0){
            System.out.println(vertical_shift);
            for (int i = (int) (location[1]-Math.signum(vertical_shift)); location[1]-Math.abs(vertical_shift) < i&&i < location[1]+Math.abs(vertical_shift); i-=Math.signum(vertical_shift)) {
                if(!board.isEmpty(location[0],i)){
                    return false;
                }
            }
        }
        else if(vertical_shift == 0){
            for (int i = (int) (location[0]-Math.signum(horizontal_shift)); location[0]-Math.abs(horizontal_shift) < i&&i < location[0]+Math.abs(horizontal_shift); i-=Math.signum(horizontal_shift)) {
                if(!board.isEmpty(i,location[1])){
                    return false;
                }
            }
        }
        System.out.println("worked");
        return true;
    }

/**
 * takes care of return a string arrayList of the queen's vision
 * @param location initial space of the piece
 * @param board dictionary of the board
 * @return the vision of the queen piece !left to be done!
 */
    @Override
    public int[][] getVision(int[] location,Board board){
        return null;
    }


    @Override
    public boolean canMove(int[] location, Board board){
        return canMove(this.location[1]-location[1],this.location[0]-location[0],location,board,true);
    }

    @Override
    public boolean hasMoved() {
        return true;
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
