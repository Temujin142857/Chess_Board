import Chess_Set.Board;

public class Player { //sets the basics attributes of a player like color, and handles all actions made by a player
    private char colour;

    /**
     * Constructor
     * @param colour the colour which this player will be using
     */
    public Player(char colour){
        this.colour=colour;
    }

    public int move(Board board, int[] location1, int[] location2){
        // to be done
        // player selects a square to move to, a call is made to the board requesting to move
        // if move is illegal player is prompted to select another move
            // if the player tries to move the wrong coloured piece
            if (board.at(location1[0],location1[1]).getName().charAt(0)!=colour){
                System.out.println(board.at(location1).getName().charAt(0));
                System.out.println("wrong colour");
                return 0;
            }
        return board.move(location1,location2);
    }

    public int[] getLocation(String location){
        char[] temp=location.toCharArray();
        int[] result=new int[2];
        for (int i=0;i< temp.length;i++) {
            if(Character.isDigit(temp[i]))result[i]=temp[i]-49;
            else{
                switch (temp[i]){
                    case 'a':result[i]=0;
                        break;
                    case 'b':result[i]=1;
                        break;
                    case 'c':result[i]=2;
                        break;
                    case 'd':result[i]=3;
                        break;
                    case 'e':result[i]=4;
                        break;
                    case 'f':result[i]=5;
                        break;
                    case 'g':result[i]=6;
                        break;
                    case 'h':result[i]=7;
                        break;
                }
            }
        }
        return result;
    }

    public boolean isCheckmate(Board board){
        // use vision, to find if a player lost -> useful for the main.
        return false;
    }

}
