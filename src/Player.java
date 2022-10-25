import Chess_Set_Folder.Board;

public class Player { //sets the basics attributes of a player like color, and handles all actions made by a player
    private char colour;

    /**
     * Constructor
     * @param colour the colour which this player will be using
     */
    public Player(char colour){
        this.colour=colour;
    }

    public boolean move(Board board){
        // to be done
        // player selects a square to move to, a call is made to the board requesting to move
        // if move is illegal player is prompted to select another move
        while (true) {
            int[] location1=null;//take input
            int[] location2=null;//take input

            if (board.at(location1[0],location1[1]).getName().charAt(0)!=colour){continue;}// if the player tries to move the wrong coloured piece
            if (board.move(location1,location2)){break;}//try and make the move
        }

        return false;
    }

    public boolean isCheckmate(Board board){
        // use vision, to find if a player lost -> useful for the main.
        return false;
    }

}
