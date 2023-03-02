package main;

import images.haractersPhotos.Heroes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class SeclectHeroPanel extends JPanel {
    public List<JButton> list = new ArrayList<>();
    final int originalTitleSize = 16;
    final int scale = 3;
    public final int titleSize = originalTitleSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int ScreenWith = titleSize * maxScreenCol;
    public final int ScreenHeight = titleSize * maxScreenRow;

    public String character;

public void initializeList(){
    JButton rtb = new JButton();
    try {
        Image img = ImageIO.read(new FileInputStream("src/images/haractersPhotos/redturtle.jpg")).getScaledInstance(500,200,Image.SCALE_DEFAULT);
        rtb.setIcon(new ImageIcon(img));

    } catch (Exception ex) {
        System.out.println(ex);
    }
    rtb.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
          character = "RED";

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


    });

    JButton ptb = new JButton();
    try {
        Image img = ImageIO.read(new FileInputStream("src/images/haractersPhotos/purple.jpg")).getScaledInstance(500,200,Image.SCALE_DEFAULT);
        ptb.setIcon(new ImageIcon(img));

    } catch (Exception ex) {
        System.out.println(ex);
    }
    ptb.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            character ="PURPLE";

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
    });
    JButton btb = new JButton();
    try {
        Image img = ImageIO.read(new FileInputStream("src/images/haractersPhotos/blue.jpg")).getScaledInstance(500,200,Image.SCALE_DEFAULT);
        btb.setIcon(new ImageIcon(img));

    } catch (Exception ex) {
        System.out.println(ex);
    }
    btb.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            character = "BLUE";

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
    });
    JButton otb = new JButton();
    try {
        Image img = ImageIO.read(new FileInputStream("src/images/haractersPhotos/orange.jpg")).getScaledInstance(500,200,Image.SCALE_DEFAULT);
        otb.setIcon(new ImageIcon(img));

    } catch (Exception ex) {
        System.out.println(ex);
    }
    otb.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            character="ORANGE";

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
    });
    JButton ratb = new JButton();
    try {
        Image img = ImageIO.read(new FileInputStream("src/images/haractersPhotos/splinter.jpg")).getScaledInstance(500,200,Image.SCALE_DEFAULT);
        ratb.setIcon(new ImageIcon(img));

    } catch (Exception ex) {
        System.out.println(ex);
    }
    ratb.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            character ="RAT";

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
    });
    JButton shrb = new JButton();
    try {
        Image img = ImageIO.read(new FileInputStream("src/images/haractersPhotos/shredder.jpg")).getScaledInstance(500,200,Image.SCALE_DEFAULT);
        shrb.setIcon(new ImageIcon(img));

    } catch (Exception ex) {
        System.out.println(ex);
    }
    shrb.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            character = "SHREDDER";

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
    });
    list.add(rtb);
    list.add(ptb);
    list.add(btb);
    list.add(otb);
    list.add(ratb);
    list.add(shrb);

}


public  JTable tableOfHeroes = new JTable();
public  GridLayout experimentLayout = new GridLayout(0,2);

    // set playlers default position

    public SeclectHeroPanel() {

        this.setPreferredSize(new Dimension(ScreenWith, ScreenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setLayout(experimentLayout);
        initializeList();


   for (JButton l :list){
       this.add(l);
   }

//        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
