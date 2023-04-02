import Chess_Set.Game;

import java.io.IOException;

public class Main { //main for the project, work in progress; play not finish.

    public static void main(String[] args) throws IOException {
        Game board=new Game();
        GUI gui= new GUI();
        gui.play(board);
    }

}
