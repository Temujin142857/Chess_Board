import Pieces_Folder.EMPTY;
import Pieces_Folder.Piece;

import java.util.HashMap;

public class Board {
    final String[] WPIECENAMES ={"WRook1","WKnight1","WBishop1","WQueen","WKing","WBishop2","WKnight2","WRook2","WPawn1","WPawn2","WPawn3","WPawn4","WPawn5","WPawn6","WPawn7","WPawn8"};
    final String[] BPIECENAMES ={"BRook1","BKnight1","BBishop1","BQueen","BKing","BBishop2","BKnight2","BRook2","BPawn1","BPawn2","BPawn3","BPawn4","BPawn5","BPawn6","BPawn7","BPawn8"};
    final String[] LETTERS ={"a","b","c","d","e","f","g","h"};
    HashMap<String, Piece> board = new HashMap<String, Piece>();
    EMPTY empty=new EMPTY();


    public Board(){
        for (int i = 0; i < 64; i++) {
            if (i < 16) {
                board.put(LETTERS[i % 8] + i / 8, Piece.makePiece(WPIECENAMES[i]));
            }
            if(16<=i&&i<48){
                board.put(LETTERS[i % 8] + i / 8, empty);
            }
            if(48<=i&&i<64){
                board.put(LETTERS[i%8]+i/8, Piece.makePiece(BPIECENAMES[i]));
            }
        }
    }

    public boolean move(String location1,String location2){
        boolean pawnIsCapturing=false;
        int horizontal_shift=location1.charAt(0)-location2.charAt(0);
        int vertical_shift=location1.charAt(1)-location2.charAt(1);
        if(!board.containsKey(location1)||!board.containsKey(location2)){
            System.out.println("invalid location");
            return false;
        }
        if(board.get(location2)!=empty){pawnIsCapturing=true;}
        if (board.get(location1).canMove(horizontal_shift,vertical_shift,location1,board,pawnIsCapturing)){
            board.put(location2,board.get(location1));
            board.put(location1, empty);
            return true;
        }
        return false;
    }

    public boolean isEmpty(String location){
        if(board.get(location)==empty){return true;}
        return false;
    }

}
