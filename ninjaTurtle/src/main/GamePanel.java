package main;

import entities.Player;
import images.background.tile.TileManager;
import mechanics.LevelHandle;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //    screen settings
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
    int playerY = 100;
    int playerSpeed = 4;
    int FPS= 60;
    // dodawanie tła do gry
    TileManager tileManager  = new TileManager(this);

    // dodawanie grawitacji
    public  LevelHandle level = new LevelHandle();

    Player player = new Player(this,keyH,60,60);

    public GamePanel() {

        this.setPreferredSize(new Dimension(ScreenWith, ScreenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {


            // nie ruszać tych metod
            // update positions of object
           ;
//        if(player.collisionOn==false) {
            player.tick();
            level.tick();
//        }


            update();

            // draw updated information on the screen
            repaint();
            System.out.println(player.x + " "  + player.y);
            if (player.y < 10 && player.x > 722){
                new EngGameGui();
                System.out.println("koniec");
            }

            try {

                double remainTime = nextDrawTime - System.nanoTime();
                remainTime = remainTime/1000000;
                if(remainTime<0){
                    remainTime = 0;
                }
                Thread.sleep((long)remainTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void update() {
      player.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
       player.draw(g2);
       level.Render(g);

        g2.dispose();
    }
}
