package Chess_Set;

import Chess_Set.Pieces_Classes.EMPTY;
import Chess_Set.Pieces_Classes.Piece;

public class Board { //represents the game board
    final private String[][] WPIECENAMES ={new String[]{"WRook1","WKnight1","WBishop1","WQueen","WKing","WBishop2","WKnight2","WRook2"}, new String[]{"WPawn1","WPawn2","WPawn3","WPawn4","WPawn5","WPawn6","WPawn7","WPawn8"}}; //white pieces
    final private String[][] BPIECENAMES ={new String[]{"BRook1","BKnight1","BBishop1","BQueen","BKing","BBishop2","BKnight2","BRook2"}, new String[]{"BPawn1","BPawn2","BPawn3","BPawn4","BPawn5","BPawn6","BPawn7","BPawn8"}}; //black pieces
    final private String[] LETTERS ={"a","b","c","d","e","f","g","h"}; // letters for the horizontal lines.
    final private EMPTY empty=new EMPTY("EMPTY",null); // create an empty object, which represents an empty square on the board
    private Piece[][] pieces = new Piece[8][8]; // array that contains all the pieces.

    /**
     * Constructor
     * Makes the array that holds all the pieces
     * Chess_Set_Folder.Pieces_Folder.Board is made in the starting position
     */
    public Board(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j<2) { // for the squares on the first and second rank
                    pieces[i][j]= Piece.makePiece(WPIECENAMES[j][i],new int[]{i,j}); //set up white pieces
                }
                else if (j<6) { // for the squares on ranks 3 through 6
                    pieces[i][j]= empty; // fill the empty squares
                }
                else { // for the squares on ranks 7 and 8
                    pieces[i][j]=Piece.makePiece(BPIECENAMES[1-(j%2)][i],new int[]{i,j}); //sets up all the black pieces
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(!pieces[i][j].getName().equals("EMPTY")) {
                    pieces[i][j].updatePossibleMoves(this);
                    pieces[i][j].updateBlockedMoves(this);
                }
            }
        }
    }

    public Board(Piece[][] pieces){
        this.pieces = pieces;
    }

    /**
    * evaluates the possibility of the move and executes it if possible
    * @param location1 starting location
    * @param location2 ending location
    * @return int 0 if the move isn't legal, 1 if the move is made, 2 is it's made and castling
    */
    public int move(int[] location1,int[] location2){
        int horizontal_shift=location2[0]-location1[0];
        int vertical_shift=location2[1]-location1[1];
        if(vertical_shift==0&&horizontal_shift==0){
            System.out.println("Can't move a piece to the square it's already on");
            return 0;
        }
        if(!isValidLocation(location1)||!isValidLocation(location2)){
            System.out.println("invalid location, board line 47");
            return 0;
        }
        if(at(location2).getName().charAt(0)==at(location1).getName().charAt(0)){
            System.out.println("you can't capture your own piece");
            return 0;
        }
        if(wouldBeCheck(location1,location2)){
            System.out.println("can't move there, you would be in check");
            return 0;
        }

        if (at(location1).canMove(horizontal_shift,vertical_shift,this,isPawnCapturing(location1,location2)))
        {
            at(location1).setHasMoved(true);
            boolean castling=isCastling(location1,location2);
            at(location1).setLocation(location2);
            if(castling){
                //castling assumes the king was clicked, so the rook has to be found
                int[] rookLocation=new int[]{(int)(1.75*(location2[0]-2)),location1[1]};
                int[] newRookLocation=new int[]{location2[0]+Integer.signum(location1[0]-location2[0]),location2[1]};
                at(rookLocation).setHasMoved(true);
                at(rookLocation).setLocation(newRookLocation);
                pieces[location2[0]][location2[1]]=at(location1);
                pieces[newRookLocation[0]][newRookLocation[1]]=at(rookLocation);
                pieces[location1[0]][location1[1]]=empty;
                pieces[rookLocation[0]][rookLocation[1]]=empty;
            }
            else{
                pieces[location2[0]][location2[1]]=at(location1);
            }
            pieces[location1[0]][location1[1]]=empty;
            for (Piece[] pieces: pieces){
                for (Piece piece:pieces) {
                    //the contains method is comparing objects, since it's 2d array, not the elements in the array
                    if(!piece.getName().equals("EMPTY")&&(piece.getBlockedMoves().contains(location1)||piece.getPossibleMoves().contains(location2))){
                        piece.updatePossibleMoves(this);
                    }
                }
            }
            if (castling){return 2;}
            return 1;
        }
        System.out.println("illegal move line 103 board");
        System.out.println(pieces[location1[0]][location1[1]].getName());
        return 0;
    }

    private boolean isPawnCapturing(int[] location1,int[] location2){
        return (at(location1).getName().charAt(1)=='P' && !at(location2).getName().equals("EMPTY"));
    }

    private boolean isCastling(int[] location1, int[] location2){
        if (at(location1).getName().charAt(1)=='K'&&at(location1).getName().charAt(2)!='n'&&Math.abs(location1[0]-location2[0])==2){
            return true;
        }
        else if (at(location1).getName().charAt(1)=='R'&&at(location2).getName().charAt(1)=='K'&&at(location1).getName().charAt(0)==at(location2).getName().charAt(0)){
            return true;
        }
        return false;
    }


    public boolean isValidLocation(int[] location){
        for (int coord:location) {
            if(coord<0||coord>7){return false;}
        }
        return true;
    }

    //add a method named would king be in check, loops through every piece on the board, checks if they could move to the given square

    /**
     * takes the kingLocation of the king and checks if any pieces are attacking it
     * @param kingLocation the kingLocation of the king
     * @return
     */
    public boolean isCheck(int[] kingLocation, Board board){
        System.out.println("wussup"+board.at(2,2).getName());
        for (Piece[] pieces:board.getPieces()){
            for (Piece piece:pieces) {
                if (!piece.getName().equals("EMPTY") //doesn't check empty pieces
                    && piece.getName().charAt(0)!=board.at(kingLocation).getName().charAt(0) //only checks pieces the opposite colour as the king
                    && piece.canMove(kingLocation, board))
                {
                    System.out.println("piece at "+piece.getLocation()[0]+", "+piece.getLocation()[1]);
                    System.out.println("piece that is checking:"+piece.getName());
                    System.out.println(at(kingLocation).getName());
                    System.out.println("ischeck");
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isCheckmate(int[] location, Board board) {
        Piece[][] pieces=board.getPieces();
        if (!isCheck(location, board)) return false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!pieces[i][j].getName().equals("EMPTY")) {
                    for (int[] move : pieces[i][j].getPossibleMoves()) {
                        if (!wouldBeCheck(new int[]{i, j}, move)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * makes the move, checks if the king of the player who would make the move is in check
     * @param location1
     * @param location2
     * @return
     */
    public boolean wouldBeCheck(int[] location1, int[] location2){
        char colour=at(location1).getName().charAt(0);
        System.out.println("colour to check: "+colour);
        Piece[][] possible_board=new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                possible_board[i][j]=Piece.makePiece(this.at(i,j).getName(),new int[]{i,j});
            }
        }
        Board board2=new Board(possible_board);
        board2.moveWithoutCheck(location1,location2);
        System.out.println("made it this far");
        return isCheck(board2.findKing(colour),board2);
    }


    public int moveWithoutCheck(int[] location1, int[] location2){
        int horizontal_shift=location2[0]-location1[0];
        int vertical_shift=location2[1]-location1[1];
        if(vertical_shift==0&&horizontal_shift==0){
            System.out.println("Can't move a piece to the square it's already on");
            return 0;
        }
        if(!isValidLocation(location1)||!isValidLocation(location2)){
            System.out.println("invalid location, board line 47");
            return 0;
        }
        if(at(location2).getName().charAt(0)==at(location1).getName().charAt(0)){
            System.out.println("you can't capture your own piece");
            return 0;
        }

        if (at(location1).canMove(horizontal_shift,vertical_shift,this,isPawnCapturing(location1,location2)))
        {
            at(location1).setHasMoved(true);
            boolean castling=isCastling(location1,location2);
            at(location1).setLocation(location2);
            if(castling){
                //castling assumes the king was clicked, so the rook has to be found
                int[] rookLocation=new int[]{(int)(1.75*(location2[0]-2)),location1[1]};
                int[] newRookLocation=new int[]{location2[0]+Integer.signum(location1[0]-location2[0]),location2[1]};
                at(rookLocation).setHasMoved(true);
                at(rookLocation).setLocation(newRookLocation);
                pieces[location2[0]][location2[1]]=at(location1);
                pieces[newRookLocation[0]][newRookLocation[1]]=at(rookLocation);
                pieces[location1[0]][location1[1]]=empty;
                pieces[rookLocation[0]][rookLocation[1]]=empty;
            }
            else{
                pieces[location2[0]][location2[1]]=at(location1);
            }
            pieces[location1[0]][location1[1]]=empty;
            if (castling){return 2;}
            return 1;
        }
        System.out.println(pieces[location1[0]][location1[1]].getName());
        return 0;
    }


    public int[] findKing(char colour){
        for (Piece[] column: pieces) {
            for (Piece piece:column) {
                if (piece.getName().equals(colour+"King")){return piece.getLocation();}
            }
        }
        return null;
    }

    public void put(int[] location1, int[] location2){
        pieces[location2[0]][location2[1]]=at(location1);
        pieces[location1[0]][location1[1]]=empty;
    }

    /**
     * Checks if a location on board is empty or not
     * @param location location desired to be checked
     * @return if location is empty or not
     */
    public boolean isEmpty(int[] location){
        return pieces[location[0]][location[1]].getName().equals("EMPTY");
    }

    public boolean isEmpty(int x, int y){
        return pieces[x][y].getName().equals("EMPTY");
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public Piece at(int[] location){
        return pieces[location[0]][location[1]];
    }

    public Piece at(int x, int y){
        return pieces[x][y];
    }

    //potentially useful deprecated code

    /**
     * returns the square the rook should go to
     * th two inputs are the location of two pieces
     * one of them is the king the other is the rook, but this method doesn't know which is which
     * @param location1
     * @param location2
     * @return
     */
    //redo this method, so that it returns a 2d array
    //where the array in result[0] is the square the piece at location 1 goes to
    //and the array in result[1] is the square the piece at location2 goes to
    private int[][] castlingLocation(int[] location1, int[] location2){
        int[][] result = new int[][]{new int[]{2,location1[1]},new int[]{3,location2[1]}};//initialised as though location2 is rook and queenside
        switch (location1[0]){
            case 0://location1 is the rook and it's queenside castling
                result[0][0]=3;
                result[1][0]=2;
            case 7://location1 is the rook and it's kingside castling
                result[0][0]=5;
                result[1][0]=6;
            default://so this only needs to account for location2 is the rook and it was kingside
                if(location2[0]==7) {
                    result[0][0] = 6;
                    result[1][0] = 5;
                }
        }
        return result;
    }

    public boolean canMove(int[] location1,int[] location2){
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

        if (at(location1).canMove(horizontal_shift,vertical_shift,this,isPawnCapturing(location1,location2))&&!wouldBeCheck(location1,location2)){
            return true;
        }
        return false;
    }
}
