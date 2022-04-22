package Pieces_Folder;

import java.util.HashMap;

public interface Piece {
/**
 * Creates the piece corresponding to the name it is passed
 * @param name normal string that should contain the name of a piecce
 * @return a new piece of the choice
 */
 static Piece makePiece(String name){
     if (name.charAt(1)=='R'){return new Rook(name);}
     if (name.charAt(2)=='n'){return new Knight(name);}
     if (name.charAt(1)=='B'){return new Bishop(name);}
     if (name.charAt(1)=='Q'){return new Queen(name);}
     if (name.charAt(1)=='P'&&name.charAt(0)=='W'){return new WPawn(name);}
     if (name.charAt(1)=='P'&&name.charAt(0)=='B'){return new BPawn(name);}
     return new King(name);
 }
/**
 * classic interface stuff
 */
    String getName();
    String[] getVision(String location,HashMap<String,Piece> board);
    boolean canMove(int vertical_shift, int horizantal_shift, String location, HashMap<String, Piece> board, boolean isCaptuing);
}
