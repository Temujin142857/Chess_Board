package Pieces_Folder;


import java.util.ArrayList;

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
    public int[][] getVision(int[] location,Piece[][] board){
        ArrayList<String> moves=new ArrayList<>();
        String square_being_checked;
        for (int i = 0; i < 8; i++) {
            square_being_checked=location.charAt(0)+String.valueOf(i+1);
            if (board.containsKey(square_being_checked)&&board.get(square_being_checked).getName().equals("EMPTY")){
                moves.add(square_being_checked);
            }
            square_being_checked=letters[i]+location.charAt(1);
            if (board.containsKey(square_being_checked)&&board.get(square_being_checked).getName().equals("EMPTY")){
                moves.add(square_being_checked);
            }
        }
        return moves.toArray(new String[0]);


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
    public boolean canMove(int vertical_shift, int horizontal_shift, int[] location, Piece[][] board, boolean isCapturing) {
        if(horizontal_shift == 0){
            for (int i = location[1]; i < 8 && i > 0; i+=Math.signum(vertical_shift)) {
                if(!board[location[0]][i].getName().equals("EMPTY")){
                    return false;
                }
            }
        }
        else if(vertical_shift == 0){
            for (int i = location[0]; i < 8 && i > 0; i+=Math.signum(horizontal_shift)) {
                if(!board[i][location[1]].getName().equals("EMPTY")){
                    return false;
                }
            }
        }
        else return false;

        return true;
    }
}
