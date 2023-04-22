import Chess_Set.Board;

import java.io.IOException;

public class Main { //main for the project, work in progress; play not finish.

    public static void main(String[] args) throws IOException {
        GUI gui= new GUI();
        gui.play(new Board());
    }

}
