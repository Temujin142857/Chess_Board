package Chess_Set.Pieces_Classes;

import Chess_Set.Board;

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
    public boolean canMove(int horizontal_shift, int vertical_shift, int[] location, Board board, boolean isCapturing) {
        if(Math.abs(horizontal_shift)<=1&& Math.abs(vertical_shift)<=1){
            setLocation(new int[] {location[0]+horizontal_shift,location[1]+vertical_shift});
            hasMoved=true;
            return true;
        }
        System.out.println(board.at(location[0]+horizontal_shift+Integer.signum(horizontal_shift),location[1]+vertical_shift).getName());
        System.out.println(horizontal_shift);
        System.out.println(location[0]+horizontal_shift+(Integer.signum(horizontal_shift)));
        System.out.println(vertical_shift);
        System.out.println(!hasMoved);
        if(!(Math.abs(horizontal_shift)==2)||!(vertical_shift==0)){return false;}//makes sure castling is going to a valid square
        if(((Math.signum(horizontal_shift)==1&&!board.at(7,location[1]).hasMoved())||(Integer.signum(horizontal_shift)==-1&&!board.at(0,location[1]).hasMoved()))&&!hasMoved){
            for (int i = location[0]+Integer.signum(horizontal_shift); i!=location[0]+horizontal_shift+Integer.signum(horizontal_shift); i+=Integer.signum(horizontal_shift)) {
                if (!board.isEmpty(i, location[1])) {
                    return false;
                }
            }
            hasMoved=true;
            setLocation(new int[] {location[0]+horizontal_shift,location[1]+vertical_shift});
            board.put(new int[]{(int) ((2+horizontal_shift)*1.75),location[1]},new int[]{location[0]+horizontal_shift+(Integer.signum(horizontal_shift)*-1),location[1]});
            //wierd math in the line about just makes location 1's x coordinate 0 when horizontal shift is negative, and 7 when it's positive
            return true;
        }
        return false;
    }

    @Override
    public boolean canMove(int[] location, Board board){
        return canMove(location[0]-this.location[0],location[1]-this.location[1],location,board,true);
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
