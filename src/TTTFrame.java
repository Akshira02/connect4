import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
//removed all keylisteners
public class TTTFrame extends JFrame  {
    // Display message
    private String text = "";
    // the letter you are playing as
    private char player;
    // stores all the game data
    private GameData gameData = null;
    // output stream to the server
    ObjectOutputStream os;
    int xoffset = 30;
    int yoffset = 60;

    public TTTFrame(GameData gameData, ObjectOutputStream os, char player)
    {
        super("TTT Game");
        // sets the attributes
        this.gameData = gameData;
        this.os = os;
        this.player = player;



        // makes closing the frame close the program
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set initial frame message
        if(player == 'X')
            text = "Waiting for O to Connect";

        setSize(550,420);
        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(true);


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX() + ", " + e.getY());
                int r = ((e.getX() - xoffset) /70);
                int c =   ((e.getY()- yoffset)/60);
                if(player == 'X')
                    gameData.getGrid()[r][c] = 'R';
                else
                    gameData.getGrid()[r][c] = 'B';


//                System.out.println(((e.getX() - xoffset) /70) + ", " + ((e.getY()-yoffset)/60));
//                if (gameData.getGrid()[r][c] == 'B') {
//                    System.out.println("R " + r + " C: " + c + " Blue ");
//                    g.setColor(Color.BLUE);
//                    g.fillOval(xoffset + r  * 70, yoffset + c  * 60,  50, 50);;
//
//                } else if (gameData.getGrid()[r][c] == 'R') {
//                    System.out.println("R " + r + " C: " + c + " Red ");
//                    g.setColor(Color.RED);
//                    g.fillOval(xoffset + r  * 70, yoffset + c  * 60,  50, 50);;
//                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //                        System.out.println(e.getX() + ", " + e.getY());
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
        });
    }


//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        for (int i = 0; i < 20; i++) {
//            for (int j = 0; j < 20; j++) {
//
//                if (TrashMap.grid[i][j].filled == true) {
//                    this.x = insetx + i * (width + (alignment) + (gap));
//                    this.y = insety + j * (width + (alignment) + (gap));
//                    TrashMap.grid[i][j].xpositionStart = this.x - alignment;
//                    TrashMap.grid[i][j].ypositionStart = this.y - alignment;
//                    TrashMap.grid[i][j].xpositionEnd = this.x + 10;
//                    TrashMap.grid[i][j].ypositionEnd = this.y + 10;
//
//                    g.setColor(java.awt.Color.white);
//                    g.fillRect(this.x, this.y, 10, 10);
//
//                    g.setColor(java.awt.Color.black);
//                    g.drawRect(this.x, this.y, 10, 10);
//
//                    g.drawRect(this.x - alignment, this.y - alignment, 10, 10);
//                    g.fillRect(this.x - alignment, this.y - alignment, 10, 10);
//
//                } else {
//                    this.x = insetx + i * (width + (alignment) + (gap));
//                    this.y = insety + j * (width + (alignment) + (gap));
//                    TrashMap.grid[i][j].xpositionStart = this.x;
//                    TrashMap.grid[i][j].ypositionStart = this.y;
//                    TrashMap.grid[i][j].xpositionEnd = this.x + 10;
//                    TrashMap.grid[i][j].ypositionEnd = this.y + 10;
//
//                    TrashMap.grid[i][j].x = this.x;
//                    TrashMap.grid[i][j].y = this.y;
//
//                    g.setColor(java.awt.Color.black);
//                    g.drawRect(this.x, this.y, 10, 10);
//                    g.setColor(java.awt.Color.white);
//                    g.fillRect(this.x, this.y, 10, 10);
//
//                }
//            }
//        }
//        for (int i = 0; i < 20; i++) {
//            for (int j = 0; j < 20; j++) {
//                System.out.print(TrashMap.grid[i][j].xpositionStart  + ", " + TrashMap.grid[i][j].ypositionStart  + "  ");
//            }
//            System.out.println();
//        }
//
//        this.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println(e.getX() + ", " + e.getY());
//                FindTrashCanClicked(e.getX(), e.getY());
//                System.out.println("Trash clicked " + foundx + " " + foundy);
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                //                        System.out.println(e.getX() + ", " + e.getY());
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });
//
//    }

    public void paint(Graphics g)
    {
//background
        g.setColor(Color.yellow);
        g.fillRect(0,0,getWidth(),getHeight());

        // draws the display text to the screen
        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman",Font.BOLD,30));
        g.drawString(text,20,55);

        // grid
        g.setColor(Color.white);
//        for(int y =0;y<=7; y++)
//            g.drawLine(0,((y+1)*133+60),getWidth(),((y+1)*133+60)/7);
//        for(int x =0;x<7; x++)
//            g.drawLine((x+1)*133,60,((x+1)*133),getHeight());
        int xoffset = 30;
        int yoffset = 60;
        for(int y =0;y<6; y++)
        {
            for(int x =0;x<7; x++) {
                //center it
                System.out.println("X:" + x + " Y:" + y + " X Pos:" + (xoffset + x  * 70) + " Y Pos:" + (yoffset + y  *60));
                g.fillOval(xoffset + x  * 70, yoffset + y  * 60,  50, 50);
            }
        }


        // player moves
        System.out.println("gameData.getGrid().length " + gameData.getGrid().length);
        for(int r=0; r<gameData.getGrid().length; r++)
            for(int c=0; c<gameData.getGrid()[0].length; c++) {
                System.out.println("R " + r + " C: " + c);
                if (gameData.getGrid()[r][c] == 'B') {
                    System.out.println("R " + r + " C: " + c + " Blue ");
                    g.setColor(Color.BLUE);
                    g.fillOval(xoffset + r  * 70, yoffset + c  * 60,  50, 50);;

                } else if (gameData.getGrid()[r][c] == 'R') {
                    System.out.println("R " + r + " C: " + c + " Red ");
                    g.setColor(Color.RED);
                    g.fillOval(xoffset + r  * 70, yoffset + c  * 60,  50, 50);;
                }
            }

    }

    public void setText(String text) {
        this.text = text;
        repaint();
    }


    public void setTurn(char turn) {
        if(turn==player)
            text = "Your turn";
        else
        {
            text = turn+"'s turn.";
        }
        repaint();
    }

    public void makeMove(int c, int r, char letter)
    {
        gameData.getGrid()[r][c] = letter;
        repaint();
    }

  //  @Override
//    public void keyTyped(KeyEvent event) {
//        char key = event.getKeyChar();
//        int r;
//        int c;
//
//        // sets the row and column, based on the entered key
//        switch(key)
//        {
//            case '1':
//                r=0;
//                c=0;
//                break;
//            case '2':
//                r=0;
//                c=1;
//                break;
//            case '3':
//                r=0;
//                c=2;
//                break;
//            case '4':
//                r=1;
//                c=0;
//                break;
//            case '5':
//                r=1;
//                c=1;
//                break;
//            case '6':
//                r=1;
//                c=2;
//                break;
//            case '7':
//                r=2;
//                c=0;
//                break;
//            case '8':
//                r=2;
//                c=1;
//                break;
//            case '9':
//                r=2;
//                c=2;
//                break;
//            default:
//                r=c=-1;
//        }
//        // if a valid enter was entered, send the move to the server
//        if(c!=-1) {
//            try {
//                os.writeObject(new CommandFromClient(CommandFromClient.MOVE, "" + c + r + player));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

//    public void keyPressed(KeyEvent e) {
//
//    }
//
//    public void keyReleased(KeyEvent e) {
//
//    }
//    this.addMouseListener(new MouseListener()
//    {
//        @Override
//        public void mouseClicked (MouseEvent e){
//            // System.out.println(e.getX() + ", " + e.getY());
//            FindTrashCanClicked(e.getX(), e.getY());
//            System.out.println("Trash clicked " + foundx + " " + foundy);
//        }

//        @Override
//        public void mousePressed (MouseEvent e){
//            //                        System.out.println(e.getX() + ", " + e.getY());
//        }
//
//        @Override
//        public void mouseReleased (MouseEvent e){
//
//        }
//
//        @Override
//        public void mouseEntered (MouseEvent e){
//
//        }

//        @Override
//        public void mouseExited (MouseEvent e){
//
//        }

}
