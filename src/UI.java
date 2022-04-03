public class UI {

    Player Wplayer=new Player('W');
    Player Bplayer=new Player('B');
    public void play(){
        Board board=new Board();
        while (true){
            Wplayer.move(board);

            Bplayer.move(board);
        }
    }

}
