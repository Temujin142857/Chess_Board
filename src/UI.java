import Chess_Set_Folder.Board;
import java.util.Scanner;

public class UI { //main for the project, work in progress; play not finish.

    Player Wplayer=new Player('W');
    Player Bplayer=new Player('B');
    public void play(){
        Board board=new Board();
        while (true){
            Wplayer.move(board);
            //needs to check if somebody has won -> somebody is in checkmate
            Bplayer.move(board);
        }
    }

    public int[] takeInput(String player){
        int[] move=new int[2];
        Scanner scanner=new Scanner(System.in);
        System.out.println(player+" please make your move");
        String input=scanner.nextLine();
        move[0]=(int) input.charAt(0);
        move[1]=(int) input.charAt(1);
        return move;
    }

}
