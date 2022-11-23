import Chess_Set_Folder.Board;

import java.util.Scanner;

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
            int[] location1=getLocation();//take input
            int[] location2=getLocation();//take input

            // if the player tries to move the wrong coloured piece
            if (board.at(location1[0],location1[1]).getName().charAt(0)!=colour){
                System.out.println("wrong colour");continue;
            }
            if (board.move(location1,location2)){break;}//try and make the move
        }

        return false;
    }

    public int[] getLocation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Where are you clicking?");
        char[] temp=scanner.nextLine().toCharArray();
        int[] result=new int[2];
        for (int i=0;i< temp.length;i++) {
            if(Character.isDigit(temp[i]))result[i]=temp[i];
            else{
                switch (temp[i]){
                    case 'a':result[i]=0;
                    case 'b':result[i]=1;
                    case 'c':result[i]=2;
                    case 'd':result[i]=3;
                    case 'e':result[i]=4;
                    case 'f':result[i]=5;
                    case 'g':result[i]=6;
                    case 'h':result[i]=7;
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
