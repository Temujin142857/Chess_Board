package Pieces_Folder;

import java.util.HashMap;

public interface Piece {
 static Piece makePiece(String name){
     if (name.charAt(1)=='R'){return new Rook();}
     if (name.charAt(2)=='n'){return new Knight();}
     if (name.charAt(1)=='B'){return new Bishop();}
     if (name.charAt(1)=='Q'){return new Queen();}
     if (name.charAt(1)=='P'&&name.charAt(0)=='W'){return new WPawn();}
     if (name.charAt(1)=='P'&&name.charAt(0)=='B'){return new BPawn();}
     return new King();
 }
String getName();

 String[] getVision(String location,HashMap<String,Piece> board);
 boolean canMove(int vertical_shift, int horizantal_shift, String location, HashMap<String, Piece> board, boolean isCaptuing);
}
