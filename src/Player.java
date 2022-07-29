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

    public void move(Board board){
        // to be done
        // player selects a square to move to, a call is made to the board requesting to move
        // if move is illegal player is prompted to select another move
    }

    public boolean isCheckmate(){
        // use vision, to find if a player lost -> usefull for the main.
        return false;
    }

}
