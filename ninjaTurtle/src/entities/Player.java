package entities;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends Entity  {
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
        y = 30;
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
   // skakanie
    public void tick(){
        x += valx;
        if (vely < gp.level.gravity){
            vely+=0.1;
        }
        if(y+vely< 430){
            y+=vely;
        }else {
            vely=0;
        }
    }
   public void update(){

        if(keyH.upPressed== true || keyH.downPressed == true || keyH.leftPressed ==true || keyH.rightPressed || keyH.spacePressed){
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
            if(keyH.spacePressed==true ){

                    if(vely==0)
                        vely = -JumpVelocity;


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
//           case "jump":
//               image = forward;
//
//
//
//               break;



       }
       if(x > 758 ){
           g2.drawImage(image,728,(int)y, gp.titleSize,gp.titleSize,null);

       }
       if(x <0  ){
           g2.drawImage(image,0,(int)y, gp.titleSize,gp.titleSize,null);

       }else  {
           g2.drawImage(image, (int) x, (int) y, gp.titleSize, gp.titleSize, null);
       }
   }

}
