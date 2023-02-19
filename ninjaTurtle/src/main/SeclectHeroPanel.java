package main;

import javax.swing.*;
import java.awt.*;

public class SeclectHeroPanel extends JPanel implements Runnable {
    final int originalTitleSize = 16;
    final int scale = 3;
    public final int titleSize = originalTitleSize * scale;
    public   final int maxScreenCol = 16;
    public  final int maxScreenRow = 12;
    public final int ScreenWith = titleSize * maxScreenCol;
    public  final int ScreenHeight = titleSize * maxScreenRow;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    // set playlers default position
    int playxerX = 100;
    int playerY = 150;
    int playerSpeed = 4;
    int FPS= 60;
    public SeclectHeroPanel() {
        this.setPreferredSize(new Dimension(ScreenWith, ScreenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    @Override
    public void run() {

    }
}
