package object;

import java.awt.*;

public abstract class Object {
    public byte Platform = Byte.MIN_VALUE;
    protected int ID;
    public abstract void Render(Graphics g);
    public abstract void tick();


}
