import Chess_Set.Board;
import Chess_Set.Pieces_Classes.Piece;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

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
    private Component labelHeld;
    private Player Wplayer;
    private Player Bplayer;
    private Board board;
    public JPanel[] panels=new JPanel[65];
    private int width=90;
    private int height=90;
    private int horizontal_shift_right = 35;
    private int vertical_shift_down=35;
    private boolean isCheckmate=false;

    private JFrame frame= new JFrame("Tomio's Chessboard");

    public void play(Board board) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(820,820));
        frame.pack();
        Wplayer=new Player('W');
        Bplayer=new Player('B');
        this.board=board;
        initialiseSquares();
        initialisePieces(board);
        frame.setVisible(true);
    }

    private void initialiseSquares(){
        int x;
        int y;
        for (int i=0;i<65;i++) {
            x=(i/8)*width+ horizontal_shift_right;
            y=((i%8)*height+vertical_shift_down);
            panels[i]=new JPanel();
            if (i%2==0&&((i/8)%2==0))panels[i].setBackground(Color.lightGray);
            else if (i%2==1&&((i/8)%2==1))panels[i].setBackground(Color.lightGray);
            else panels[i].setBackground(Color.white);
            panels[i].setBounds(x,y,width,height);
            if(i!=64)panels[i].addMouseListener(new MouseListener());
            frame.add(panels[i]);
        }
        panels[64].setBackground(new Color(115,86,4));
    }


    //file path equals, "src/" + pieceName + ".png"
    //need to test if the same names for labels/images overrides them
    //seems like on board the pieces are ordered
    private void initialisePieces(Board board) throws IOException {
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

    /**
     * Listens for mouse clicks
     * Stores the held piece, tries to move the held piece to a new square
     * storing pieces as an x and y is a bit akward since panels is a one dimensional array
     * but I need both values for the move function in board
     * could make panels a two dimensional array, just using x*8+y works fine though
     */
    private class MouseListener implements java.awt.event.MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x=(e.getComponent().getX()- horizontal_shift_right)/width;
            int y=(e.getComponent().getY()-vertical_shift_down)/height;
            if (!isPieceHeld){isPieceHeld=true;pieceHeld=new int[]{x,y};highlightBorder(panels[x*8+y]);System.out.println("Piece selected");return;}
            else if (white_active){
                int moveResult=Wplayer.move(board, pieceHeld,new int[]{x,y});
                if(moveResult>0){//not castling
                    isPieceHeld=false;white_active=false;
                    moveAPieceToASquare(pieceHeld,new int[]{x,y});
                    if (board.isCheckmate(board.findKing('B'),board.getBoard())){
                        System.out.println("checkmate");
                        isCheckmate=true;
                    }
                    if (moveResult==2){//is castling
                        moveAPieceToASquare(new int[]{(int)(1.75*(x-2)),y},new int[]{x+Integer.signum(pieceHeld[0]-x),y});
                    }
                }
            }
            else if (!white_active){
                int moveResult=Bplayer.move(board, pieceHeld,new int[]{x,y});
                if(moveResult>0){//not castling
                    isPieceHeld=false;white_active=true;
                    if(panels[x*8+y].getComponents().length!=0){panels[x*8+y].remove(0);}//if there is a piece on the square removes it
                    moveAPieceToASquare(pieceHeld,new int[]{x,y});
                    if (board.isCheckmate(board.findKing('W'),board.getBoard())){
                        System.out.println("checkmate");
                        isCheckmate=true;
                    }
                    if (moveResult==2){//is castling
                        moveAPieceToASquare(new int[]{(int)(1.75*(x-2)),y},new int[]{x+Integer.signum(pieceHeld[0]-x),y});
                    }
                }
            }
            isPieceHeld=false;unHighlightBorder(panels[pieceHeld[0]*8+pieceHeld[1]]);System.out.println("Piece deselected");
        }

        private void moveAPieceToASquare(int[] originalLocation, int[] desiredLocation){
            //if there is a piece on the square removes it
            if(panels[desiredLocation[0]*8+desiredLocation[1]].getComponents().length!=0){panels[desiredLocation[0]*8+desiredLocation[1]].remove(0);}
            //moves the held piece to the now empty square
            panels[desiredLocation[0]*8+desiredLocation[1]].add(panels[originalLocation[0]*8+originalLocation[1]].getComponent(0));
            panels[desiredLocation[0]*8+desiredLocation[1]].updateUI();
            panels[originalLocation[0]*8+originalLocation[1]].updateUI();
            frame.pack();
        }

        private void highlightBorder(JPanel panel){
            Border compound;
            Border line = BorderFactory.createLineBorder(Color.yellow);
            compound = BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder());
            compound = BorderFactory.createCompoundBorder(compound,line);
            panel.setBorder(compound);
        }

        private void unHighlightBorder(JPanel panel){
            panel.setBorder(BorderFactory.createEmptyBorder());
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

