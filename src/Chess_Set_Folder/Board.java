package Chess_Set_Folder;

import Chess_Set_Folder.Pieces_Folder.EMPTY;
import Chess_Set_Folder.Pieces_Folder.Piece;

public class Board { //represents the game board
    final private String[] WPIECENAMES ={"WRook1","WKnight1","WBishop1","WQueen","WKing","WBishop2","WKnight2","WRook2","WPawn1","WPawn2","WPawn3","WPawn4","WPawn5","WPawn6","WPawn7","WPawn8"}; //white pieces
    final private String[] BPIECENAMES ={"BRook1","BKnight1","BBishop1","BQueen","BKing","BBishop2","BKnight2","BRook2","BPawn1","BPawn2","BPawn3","BPawn4","BPawn5","BPawn6","BPawn7","BPawn8"}; //black pieces
    final private String[] LETTERS ={"a","b","c","d","e","f","g","h"}; // letters for the horizontal lines.
    final private EMPTY empty=new EMPTY("EMPTY"); // create an empty object, which represents an empty square on the board
    private Piece[][] board = new Piece[7][7]; // array that contains all the pieces.

    /**
     * Constructor
     * Makes the array that holds all the pieces
     * Chess_Set_Folder.Pieces_Folder.Board is made in the starting position
     */
    public Board(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j<2) { // for the squares on the first and second rank
                    board[i][j]= Piece.makePiece(WPIECENAMES[i]); //set up white pieces
                }
                else if (j<6) { // for the squares on ranks 3 through 6
                    board[i][j]= empty; // fill the empty squares
                }
                else { // for the squares on ranks 7 and 8
                    board[i][j]=Piece.makePiece(BPIECENAMES[i]); //sets up all the black pieces
                }
            }
        }
    }

    /**
    * evaluates the possibility of the move and executes it if possible
    * @param location1 starting location
    * @param location2 ending location
    * @return boolean representing if move is made
    */
    public boolean move(int[] location1,int[] location2){
        int horizontal_shift=location1[0]-location2[0];
        int vertical_shift=location1[1]-location2[1];

        if(!isValidLocation(location1)||!isValidLocation(location2)){
            System.out.println("invalid location");
            return false;
        }

        if (board[location1[0]][location1[1]].canMove(horizontal_shift,vertical_shift,location1,this,isPawnCapturing(location1,location2))){
            board[location2[0]][location2[1]]=this.at(location1);
            board[location1[0]][location1[1]]=empty;
            return true;
        }
        return false;
    }

    private boolean isPawnCapturing(int[] location1,int[] location2){
        return (board[location1[0]][location1[1]].getName().equals("WPawn") && !board[location2[0]][location2[1]].getName().equals("EMPTY"));
               }

    public boolean isValidLocation(int[] location){
        for (int coord:location) {
            System.out.println("error, invalid location");
            if(coord<0||coord>7){return false;}
        }
        return true;
    }

    public Piece at(int[] location){
        return board[location[0]][location[1]];
    }

    public Piece at(int x, int y){
        return board[x][y];
    }

    /**
     * Checks if a location on board is empty or not
     * @param location location desired to be checked
     * @return if location is empty or not
     */
    public boolean isEmpty(int[] location){
        return board[location[0]][location[1]]==empty;
    }

    public boolean isEmpty(int x, int y){
        return board[x][y]==empty;
    }

}
