package mechanics;

import object.Item;
import object.ObjectId;
import object.Platform;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class LevelHandle {

    public double gravity =4;
    public int CameraX=0,CameraY=0;
    public LinkedList<Item> items = new LinkedList<>();
    public int seed ;
    public LevelHandle() {
        Random r = new Random();
        seed = r.nextInt();
        System.out.println(seed);
        // platformy pionowe
//        items.add(   new Platform(ObjectId.Platform,30,480,2,300, Color.black));
     items.add(   new Platform(ObjectId.Platform,0,190,340,2, null));
        items.add(   new Platform(ObjectId.Platform,380,50,400,2, null));

        items.add(   new Platform(ObjectId.Platform,380,335,350,2, null));
     items.add(   new Platform(ObjectId.Platform,-50,480,900,2, null));
    }
    public void Render(Graphics g){

        for(Item o: items){
            o.Render(g);
        }
    }
    public void tick(){

        for(Item i : items){
            i.tick();
        }

    }
}
