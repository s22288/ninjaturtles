package object;

import java.awt.*;

public class Platform extends Item {
        public int x,y,width,height;
        public Color c;

    public Platform(byte ID, int x, int y, int width, int height,Color c) {
        super(ID);
        this.c = c;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void Render(Graphics g) {
        g.setColor(null);
        g.fillRect(x,y,width,height);
        System.out.println(Byte.MIN_VALUE);
    }

    @Override
    public void tick() {

    }
}
