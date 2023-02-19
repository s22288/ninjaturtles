package entities;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImgage();
    }
   public void setDefaultValues(){
        x =0;
        y = 430;
        speed = 4;
        direction = "down";
   }
   public void getPlayerImgage(){
       try {
           forward = ImageIO.read(new FileInputStream("src/images/forward.png"));
           backward = ImageIO.read(new FileInputStream("src/images/back.png"));
           lefts = ImageIO.read(new FileInputStream("src/images/sleft.png"));
           leftm = ImageIO.read(new FileInputStream("src/images/movleft.png"));
           rights = ImageIO.read(new FileInputStream("src/images/stayright.png"));
           rightm = ImageIO.read(new FileInputStream("src/images/movright.png"));
           fightrigt =ImageIO.read(new FileInputStream("src/images/fightright.png"));
           fightleft =ImageIO.read(new FileInputStream("src/images/fightleft.png"));

       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
   public void update(){
        if(keyH.upPressed== true || keyH.downPressed == true || keyH.leftPressed ==true || keyH.rightPressed){
            if (keyH.upPressed == true) {
                direction = "up";

            }
            if (keyH.downPressed == true) {
                direction= "down";

            }
            if (keyH.leftPressed == true) {
                direction = "left";
                x -= speed;


            }

            if (keyH.rightPressed == true) {
                direction= "right";
                x += speed;


            }
            if(keyH.spacePressed==true && direction=="left"){
                direction= "fightleft";
            }
            if(keyH.spacePressed==true && direction== "right"){
                direction= "fightright";
            }



            spriteCounter++;
            if(spriteCounter>12){

                if(spriteNum==1){
                    spriteNum=2;
                }else if(spriteNum==2){
                    spriteNum = 1;
                }

                spriteCounter=0;
            }
        }


   }
   public void draw(Graphics2D g2){
       BufferedImage image = null;
       switch (direction){
           case "up":
               image = backward;
               break;
           case "down":
               image = forward;
               break;
           case "left":
               if(spriteNum==1){
                   image = lefts;
               }
               if(spriteNum==2){
                   image = leftm;
               }

               break;
           case "right":
               if(spriteNum==1){
                   image = rights;
               }
               if(spriteNum==2){
                   image = rightm;
               }

               break;
           case "fightright":
               image= fightrigt;
              break;

           case "fightleft":

                   image = fightleft;

               break;


       }
       g2.drawImage(image,x,y, gp.titleSize,gp.titleSize,null);

   }

}
