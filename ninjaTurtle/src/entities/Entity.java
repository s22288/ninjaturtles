package entities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Entity   {
    public double x,y;
    public int speed;
    // skakanie zmienne
    public double valx , vely;

    public int width,height;
    public double JumpVelocity = 6;
    public Rectangle solidArea;
    public boolean collisionOn = false;


 public BufferedImage forward,backward,lefts,leftm,rights,rightm,fightrigt,fightleft;
 public String direction;
 public int spriteCounter= 0;
 public int spriteNum = 1;
}
