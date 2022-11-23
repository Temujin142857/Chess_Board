package Chess_Set_Folder.Pieces_Folder;

import Chess_Set_Folder.Board;

public interface Piece {
    /**
     * Creates the piece corresponding to the name it is passed
     * @param name normal string that should contain the name of a piecce
     * @return a new piece of the choice
     */
 static Piece makePiece(String name, int[] location){
     if (name.charAt(1)=='R'){return new Rook(name, location);}
     else if (name.charAt(2)=='n'){return new Knight(name, location);}
     else if (name.charAt(1)=='B'){return new Bishop(name, location);}
     else if (name.charAt(1)=='Q'){return new Queen(name, location);}
     else if (name.charAt(1)=='P'&&name.charAt(0)=='W'){return new WPawn(name, location);}
     else if (name.charAt(1)=='P'&&name.charAt(0)=='B'){return new BPawn(name, location);}
     else return new King(name, location);
 }

    /**
     * classic interface stuff
     */
    String getName();
    int[] getLocation();
    void setLocation(int[] location);
    int[][] getVision(int[] location, Board board);
    boolean canMove(int vertical_shift, int horizontal_shift, int[] location, Board board, boolean isCapturing);
    boolean canMove(int[] location, Board board);
    boolean hasMoved();
}
