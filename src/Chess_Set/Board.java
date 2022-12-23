package Chess_Set;

import Chess_Set.Pieces_Classes.EMPTY;
import Chess_Set.Pieces_Classes.Piece;

public class Board { //represents the game board
    final private String[][] WPIECENAMES ={new String[]{"WRook1","WKnight1","WBishop1","WQueen","WKing","WBishop2","WKnight2","WRook2"}, new String[]{"WPawn1","WPawn2","WPawn3","WPawn4","WPawn5","WPawn6","WPawn7","WPawn8"}}; //white pieces
    final private String[][] BPIECENAMES ={new String[]{"BRook1","BKnight1","BBishop1","BQueen","BKing","BBishop2","BKnight2","BRook2"}, new String[]{"BPawn1","BPawn2","BPawn3","BPawn4","BPawn5","BPawn6","BPawn7","BPawn8"}}; //black pieces
    final private String[] LETTERS ={"a","b","c","d","e","f","g","h"}; // letters for the horizontal lines.
    final private EMPTY empty=new EMPTY("EMPTY",null); // create an empty object, which represents an empty square on the board
    private Piece[][] board = new Piece[8][8]; // array that contains all the pieces.

    /**
     * Constructor
     * Makes the array that holds all the pieces
     * Chess_Set_Folder.Pieces_Folder.Board is made in the starting position
     */
    public Board(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j<2) { // for the squares on the first and second rank
                    board[i][j]= Piece.makePiece(WPIECENAMES[j][i],new int[]{i,j}); //set up white pieces
                }
                else if (j<6) { // for the squares on ranks 3 through 6
                    board[i][j]= empty; // fill the empty squares
                }
                else { // for the squares on ranks 7 and 8
                    board[i][j]=Piece.makePiece(BPIECENAMES[1-(j%2)][i],new int[]{i,j}); //sets up all the black pieces
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
        int horizontal_shift=location2[0]-location1[0];
        int vertical_shift=location2[1]-location1[1];
        if(vertical_shift==0&&horizontal_shift==0){
            System.out.println("Can't move a piece to the square it's already on");
            return false;
        }
        if(!isValidLocation(location1)||!isValidLocation(location2)){
            System.out.println("invalid location, board line 47");
            return false;
        }
        if(at(location2).getName().charAt(0)==at(location1).getName().charAt(0)){
            System.out.println("you can't capture your own piece");
            return false;
        }
        System.out.println("location1: "+location1[0]+","+location1[1]);
        System.out.println("at location1:"+at(location1).getName());
        if (at(location1).canMove(horizontal_shift,vertical_shift,location1,this,isPawnCapturing(location1,location2))&&!wouldBeCheck(location1,location2))
        {
            board[location2[0]][location2[1]]=at(location1);
            board[location1[0]][location1[1]]=empty;
            System.out.println("location1: "+location1[0]+","+location1[1]);
            System.out.println("at location1:"+at(location1).getName());
            System.out.println("location2: "+location2[0]+","+location2[1]);
            System.out.println("at location2:"+at(location2).getName());
            return true;
        }
        System.out.println("illegal move line 62 board");
        return false;
    }

    private boolean isPawnCapturing(int[] location1,int[] location2){
        return (at(location1).getName().charAt(1)=='P' && !at(location2).getName().equals("EMPTY"));
    }

    public boolean isValidLocation(int[] location){
        for (int coord:location) {
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

    //add a method named would king be in check, loops through every piece on the board, checks if they could move to the given square

    /**
     * takes the location of the king and checks if any pieces are attacking it
     * @param location the location of the king
     * @return
     */
    public boolean isCheck(int[] location, Piece[][] board){
        for (Piece[] pieces:board){
            for (Piece piece:pieces) {
                if (!piece.getName().equals("EMPTY") //doesn't check empty pieces
                    && piece.getName().charAt(0)!=board[location[0]][location[1]].getName().charAt(0) //only checks pieces the opposite colour as the king
                    && piece.canMove(location, this))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * makes the move, checks if the king of the player who would make the move is in check
     * @param location1
     * @param location2
     * @return
     */
    public boolean wouldBeCheck(int[] location1,int[] location2){
        char colour=at(location1).getName().charAt(0);

        Piece[][] possible_board=new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                possible_board[i][j]=Piece.makePiece(this.at(i,j).getName(),new int[]{i,j});
            }
        }
        possible_board[location2[0]][location2[1]]=possible_board[location1[0]][location1[1]];
        possible_board[location1[0]][location1[1]]=empty;
        isCheck(findKing(colour),possible_board);
        return false;
    }

    private int[] findKing(char colour){
        int[] result = null;
        for (Piece[] column:board) {
            for (Piece piece:column) {
                if (piece.getName().equals(colour+"King"))result= piece.getLocation();
            }
        }
        return result;
    }

    public void put(int[] location1, int[] location2){
        board[location2[0]][location2[1]]=at(location1);
        board[location1[0]][location1[1]]=empty;
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
        System.out.println(at(x,y).getName());
        return board[x][y]==empty;
    }

    public Piece[][] getBoard() {
        return board;
    }
}
