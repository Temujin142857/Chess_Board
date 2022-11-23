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
}
