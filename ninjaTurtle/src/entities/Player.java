package entities;

import main.GamePanel;
import main.KeyHandler;
import object.Item;
import object.ObjectId;
import object.Platform;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends Entity {

    public String hero = "RAT";
    GamePanel gp;
    KeyHandler keyH;
    public boolean Falling = true;

    public Player(GamePanel gp, KeyHandler keyH, int width, int height,String hero) {
        this.width = width;
        this.height = height;
        this.gp = gp;
        this.keyH = keyH;
        this.hero = hero;


        solidArea = new Rectangle(8, 16, 32, 32);

        setDefaultValues();
        getPlayerImgage();

    }

    public void setDefaultValues() {
        x = 50;
        y = 200;
        speed = 4;
        direction = "down";

    }

    public void getPlayerImgage() {
        try {
            if(hero.equals("RED")) {
                forward = ImageIO.read(new FileInputStream("src/images/red/forward.png"));
                backward = ImageIO.read(new FileInputStream("src/images/red/back.png"));
                lefts = ImageIO.read(new FileInputStream("src/images/red/sleft.png"));
                leftm = ImageIO.read(new FileInputStream("src/images/red/movleft.png"));
                rights = ImageIO.read(new FileInputStream("src/images/red/sleft.png"));
                rightm = ImageIO.read(new FileInputStream("src/images/red/movright.png"));
                fightrigt = ImageIO.read(new FileInputStream("src/images/red/fightright.png"));
                fightleft = ImageIO.read(new FileInputStream("src/images/red/fightleft.png"));
            }
            if(hero.equals("BLUE")) {
                forward = ImageIO.read(new FileInputStream("src/images/blue/forward.png"));
                backward = ImageIO.read(new FileInputStream("src/images/blue/back.png"));
                lefts = ImageIO.read(new FileInputStream("src/images/blue/sleft.png"));
                leftm = ImageIO.read(new FileInputStream("src/images/blue/movleft.png"));
                rights = ImageIO.read(new FileInputStream("src/images/blue/sleft.png"));
                rightm = ImageIO.read(new FileInputStream("src/images/blue/movright.png"));
//                fightrigt = ImageIO.read(new FileInputStream("src/images/blue/fightright.png"));
//                fightleft = ImageIO.read(new FileInputStream("src/images/blue/fightleft.png"));
            }
            if(hero.equals("ORANGE")) {
                forward = ImageIO.read(new FileInputStream("src/images/oragne/forward.png"));
                backward = ImageIO.read(new FileInputStream("src/images/oragne/back.png"));
                lefts = ImageIO.read(new FileInputStream("src/images/oragne/sright.png"));
                leftm = ImageIO.read(new FileInputStream("src/images/oragne/movrigth.png"));
                rights = ImageIO.read(new FileInputStream("src/images/oragne/sleft.png"));
                rightm = ImageIO.read(new FileInputStream("src/images/oragne/movleft.png"));
//                fightrigt = ImageIO.read(new FileInputStream("src/images/oragne/fightright.png"));
//                fightleft = ImageIO.read(new FileInputStream("src/images/oragne/fightleft.png"));
            }
            if(hero.equals("PURPLE")) {
                forward = ImageIO.read(new FileInputStream("src/images/purple/forward.png"));
                backward = ImageIO.read(new FileInputStream("src/images/purple/back.png"));
                lefts = ImageIO.read(new FileInputStream("src/images/purple/sleft.png"));
                leftm = ImageIO.read(new FileInputStream("src/images/purple/movleft.png"));
                rights = ImageIO.read(new FileInputStream("src/images/purple/sright.png"));
                rightm = ImageIO.read(new FileInputStream("src/images/purple/movright.png"));
//                fightrigt = ImageIO.read(new FileInputStream("src/images/purple/fightright.png"));
//                fightleft = ImageIO.read(new FileInputStream("src/images/purple/fightleft.png"));
            }
            if(hero.equals("RAT")) {
                forward = ImageIO.read(new FileInputStream("src/images/rat/forward.png"));
                backward = ImageIO.read(new FileInputStream("src/images/rat/back.png"));

                lefts = ImageIO.read(new FileInputStream("src/images/rat/sleft.png"));

                leftm = ImageIO.read(new FileInputStream("src/images/rat/movlft.png"));
                rights = ImageIO.read(new FileInputStream("src/images/rat/sright.png"));
                rightm = ImageIO.read(new FileInputStream("src/images/rat/movright.png"));
//                fightrigt = ImageIO.read(new FileInputStream("src/images/rat/fightright.png"));
//                fightleft = ImageIO.read(new FileInputStream("src/images/rat/fightleft.png"));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // skakanie
    public void tick() {
        x += valx;
        y += vely;
        if (vely < gp.level.gravity && Falling) {
            vely += 0.1;
        } else if (!Falling && vely > 0) {
            vely = 0;
        }
//        if(y+vely< 430){
//            y+=vely;
//        }else {
//            vely=0;
//        }
        Collision();
    }

    public void Collision() {
        Falling = true;
        for (Item i : gp.level.items) {
            if (i.ID == ObjectId.Platform) {
                Platform p = (Platform) i;
                if (new Rectangle((int) x, (int) y, width, height).intersects(p.x, p.y, p.width, p.height)) {
                    Falling = false;
                }
            }
        }
    }

    public void update() {

        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed || keyH.spacePressed) {
            if (keyH.upPressed == true) {
                direction = "up";
                if (vely == 0) {
                    vely = -JumpVelocity;

                }


            }
            if (keyH.downPressed == true) {
                direction = "down";

            }
            if (keyH.leftPressed == true) {
                direction = "left";
                x -= speed;


            }

            if (keyH.rightPressed == true) {
                direction = "right";
                x += speed;


            }
//            if(keyH.spacePressed==true ){
//
//                if(vely==0) {
//                    vely = -JumpVelocity;
//
//                }
//            }


            spriteCounter++;
            if (spriteCounter > 12) {

                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }

                spriteCounter = 0;
            }
        }


    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        switch (direction) {
            case "up":
                image = backward;
                break;
            case "down":
                image = forward;
                break;
            case "left":
                if (spriteNum == 1) {
                    image = lefts;
                }
                if (spriteNum == 2) {
                    image = leftm;
                }

                break;
            case "right":
                if (spriteNum == 1) {
                    image = rights;
                }
                if (spriteNum == 2) {
                    image = rightm;
                }

                break;
//           case "jump":
//               image = forward;
//
//
//
//               break;


        }
        if (x < 50) {
            g2.drawImage(image, 50, (int) y, gp.titleSize, gp.titleSize, null);

        } else if (x > 700) {
            g2.drawImage(image, 700, (int) y, gp.titleSize, gp.titleSize, null);

        } else {
            g2.drawImage(image, (int) x, (int) y, gp.titleSize, gp.titleSize, null);
        }
    }

    public void setHero(String hero) {
        this.hero = hero;
    }
}
