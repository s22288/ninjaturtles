package object;

import java.awt.*;

public abstract class Item {

    public byte ID;

    public Item(byte ID) {
        this.ID = ID;
    }

    public abstract void Render(Graphics g);
    public abstract void tick();


}
