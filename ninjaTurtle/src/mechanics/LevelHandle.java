package mechanics;

import java.util.Random;

public class LevelHandle {

    public double gravity =4;
    public int seed ;
    public LevelHandle() {
        Random r = new Random();
        seed = r.nextInt();
        System.out.println(seed);
    }
}
