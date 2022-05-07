import Pieces_Folder.EMPTY;
import Pieces_Folder.Piece;

import java.util.HashMap;

public class Board { //represents the game board
    final private String[] WPIECENAMES ={"WRook1","WKnight1","WBishop1","WQueen","WKing","WBishop2","WKnight2","WRook2","WPawn1","WPawn2","WPawn3","WPawn4","WPawn5","WPawn6","WPawn7","WPawn8"}; //white pieces
    final private String[] BPIECENAMES ={"BRook1","BKnight1","BBishop1","BQueen","BKing","BBishop2","BKnight2","BRook2","BPawn1","BPawn2","BPawn3","BPawn4","BPawn5","BPawn6","BPawn7","BPawn8"}; //black pieces
    final private String[] LETTERS ={"a","b","c","d","e","f","g","h"}; // letters for the horizontal lines.
    final private EMPTY empty=new EMPTY("EMPTY"); // create an empty object, which represents an empty square on the board
    private Piece[][] board = new Piece[7][7]; // array that contains all the pieces.

    /**
     * Constructor
     */
    public Board(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j<2) {
                    board[i][j]= Piece.makePiece(WPIECENAMES[i]); //set up white pieces
                }
                else if (j<6) {
                    board[i][j]= empty; //set up white pieces
                }
                else {
                    board[i][j]=Piece.makePiece(BPIECENAMES[i]); //sets up all the black pieces
                }
            }

        }
    }

/**
 * evaluates the possibility of the move and does it if it can
 * @param location1 starting location
 * @param location2 ending location
 * @return move is possible
 */
    public boolean move(int[] location1,int[] location2){
        boolean pawnIsCapturing=false;
        int horizontal_shift=location1[0]-location2[0];
        int vertical_shift=location1[1]-location2[1];
        if(!isValidLocation(location1)||!isValidLocation(location2)){
            System.out.println("invalid location");
            return false;
        }
        if(board[location2[0]][location2[1]]!=empty){pawnIsCapturing=true;}
        if (board[location1[0]][location1[1]].canMove(horizontal_shift,vertical_shift,location1,board,pawnIsCapturing)){
            board[location2[0]][location2[1]]=this.at(location1);
            board[location1[0]][location1[1]]=this.at(location2);
            return true;
        }
        return false;
    }

    public boolean isValidLocation(int[] location){
        for (int coord:location) {
            if(coord<0||coord>7){return false}
        }
        return true;
    }

    public Piece at(int[] location){
        return board[location[0]][location[1]];
    }

/**
 * Checks if a location on board is empty or not
 * @param location location desired to be checked
 * @return if location is empty or not
 */
    public boolean isEmpty(String location){
        if(board.get(location)==empty){return true;}
        return false;
    }

}
