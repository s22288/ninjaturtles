package entities;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Entity   {
    public double x,y;
    public int speed;
    // skakanie zmienne
    public double valx , vely;
    public double JumpVelocity = 7;


 public BufferedImage forward,backward,lefts,leftm,rights,rightm,fightrigt,fightleft;
 public String direction;
 public int spriteCounter= 0;
 public int spriteNum = 1;
}
