import Chess_Set.Board;
import Chess_Set.Pieces_Classes.Piece;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.imageio.ImageIO;


//make an empty chessboard out of panels, pieces will be buttons that sit on top of the panels
//the buttons will turn transparent if they are empty squares, and display the appropriate picture otherwise
//alternatively if I make a set of pieces on the appropriate background I can just change the panel
//on second click, data is sent to player, via it's move class
//get location in the player object can be used to turn a string of the form e4, or d5, ect, into an int array
//upon recieving confirmation that the move was made it flips the white_active boolean, and updates the form
//at some point changing the form updating method to not just scan everything would be nice
//button names can be the piece names, following the same convention in the board class
//square names can be integer coordinates, or chess notation
public class GUI {
    private boolean white_active=true;
    private boolean isPieceHeld;
    private int[] pieceHeld;
    private Player Wplayer;
    private Player Bplayer;
    private Board board;
    private JPanel[] panels=new JPanel[65];
    private int width=90;
    private int height=90;
    private int horizontal_shift_left= 35;
    private int vertical_shift_down=35;

    private JFrame frame= new JFrame("Tomio's Chessboard");

    public void play(Board board) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(820,820));
        frame.pack();
        Wplayer=new Player('W');
        Bplayer=new Player('B');
        this.board=board;
        initialise_squares();
        initialise_pieces(board);
        frame.setVisible(true);
    }

    private void initialise_squares(){
        int x;
        int y;
        for (int i=0;i<65;i++) {
            x=(i/8)*width+horizontal_shift_left;
            y=(Math.round(i%8)*height+vertical_shift_down);
            panels[i]=new JPanel();
            if (i%2==0&&((i/8)%2==0))panels[i].setBackground(Color.lightGray);
            else if (i%2==1&&((i/8)%2==1))panels[i].setBackground(Color.lightGray);
            else panels[i].setBackground(Color.white);
            panels[i].setBounds(x,y,width,height);
            panels[i].addMouseListener(new MouseListener());
            frame.add(panels[i]);
        }
        panels[64].setBackground(new Color(115,86,4));
    }

    //file path equals, "src/" + pieceName + ".png"
    //need to test if they same names for labels/images overrides them
    //seems like on board the pieces are ordered
    private void initialise_pieces(Board board) throws IOException {
        BufferedImage img;
        String pieceName;
        int i=-1;
        for (Piece[] columns:board.getBoard()) {
            for (Piece piece:columns) {
                i++;
                pieceName="";
                for (char c:piece.getName().toCharArray()){
                    if (!Character.isDigit(c)){pieceName+=c;}
                }
                if (pieceName.equals("EMPTY"))continue;
                img = ImageIO.read(new File("src/Chess_Set/Pieces_Images/" + pieceName + ".png"));
                JLabel label = new JLabel(new ImageIcon(img));
                label.setSize(90, 90);
                panels[i].add(label);
            }
        }
    }

    private class MouseListener implements java.awt.event.MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (!isPieceHeld){isPieceHeld=true;pieceHeld=new int[]{((e.getX()-horizontal_shift_left)/width),e.getY()/height};}
            else if (white_active){Wplayer.move(board, pieceHeld,new int[]{((e.getX()-horizontal_shift_left)/width),e.getY()/height});}
            else {Bplayer.move(board, pieceHeld,new int[]{((e.getX()-horizontal_shift_left)/width),e.getY()/height});}
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}

