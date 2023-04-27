//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.awt.image.BufferedImage;
//
//import java.awt.event.KeyListener;
//import java.awt.image.ImageObserver;
//import java.io.Console;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//public class TrashBinPanel extends JPanel
//{
//    int x, y;
//    int insetx = 10, insety = 10;
//    int alignment = 2;
//    int width = 10;
//    int gap = 2;
//    int foundx, foundy;
//
//    public TrashBinPanel()
//    {
//        super();
////        this.setSize(20 * (width + gap + 2 * alignment +  2 * gap) + 2 * insetx, 20 * (width + gap + 2 * alignment +  2 * gap) + 2 * insety);
//        this.setBackground(Color.white);
//        SetPanel();
//    }
//
//    public void SetPanel()
//    {
//        //setDebugGraphicsOptions(JFrame.EXIT_ON_CLOSE);
////        setSize(500, 500);
//        setSize(20 * (width + gap +  alignment +  gap) + 2 * insetx, 20 * (width + gap + alignment +   gap) + 2* insety);
////        setSize(20 * (width + gap + 2 * alignment +  2 * gap) + 2 * insetx, 20 * (width + gap + 2 * alignment +  2 * gap) + 2 * insety);
//    }
//
//    @Override
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
//
//    public void FindTrashCanClicked(int pointx, int pointy){
//        foundx=0;
//        foundy=0;
//        for (int i = 0; i < 20; i++) {
//            if (TrashMap.grid[i][0].filled) {
//                if (pointy >= TrashMap.grid[i][0].xpositionStart && (pointy <= TrashMap.grid[i][0].xpositionEnd)) {
//                    foundx = i;
//                    break;
//                }
//            }
//            else if (pointy >= TrashMap.grid[i][0].xpositionStart - alignment && (pointy <= TrashMap.grid[i][0].xpositionEnd)) {
//                foundx = i;
//                break;
//            }
//        }
//        for (int i = 0; i < 20; i++) {
//            if (TrashMap.grid[foundx][i].filled) {
//                if (pointx >= TrashMap.grid[foundx][i].ypositionStart && (pointx <= TrashMap.grid[foundx][i].ypositionEnd)) {
//                    foundy = i;
//                    break;
//                }
//            }
//            else if (pointx >= TrashMap.grid[foundx][i].ypositionStart - alignment && (pointx <= TrashMap.grid[foundx][i].ypositionEnd)) {
//                foundy = i;
//                break;
//            }
//        }
////        System.out.println("Found " + foundx + ", " + foundy);
//
//        pickUpTrash(foundx, foundy);
//
//    }
//
//    public void pickUpTrash(int r, int c)
//
//    {
//
//        System.out.println("Recursion " + r + ", " + c);
//        // ADD A BASECASE THAT STOPS THE METHOD FROM RECURSING
//        if (r >= 20 ||  c >= 20 )
//            return;
//
//
//        // CLEAN UP THE TRASH ON THE CURRENT SQUARE
//        if(TrashMap.grid[c][r].filled) {
//            TrashMap.grid[c][r].filled = false;
//            repaint();
//            // AND CALL PICKUP TRASH AS NEEDED TO CLEAN UP NEIGHBORING SQUARES
//            pickUpTrash(r - 1, c);
//            pickUpTrash(r + 1,c);
//            pickUpTrash(r, c - 1);
//            pickUpTrash(r, c + 1);
//
//        }
//        else
//            return;
//
//
//
//
//
//    }
//
//
//
//}