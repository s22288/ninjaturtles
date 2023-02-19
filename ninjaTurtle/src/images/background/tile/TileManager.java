package images.background.tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    Tile [] tiles;

    public TileManager(GamePanel gp) {
        this.gp = gp;
       tiles = new Tile[2];
       getTileImage();
    }
    public void getTileImage(){
        try{
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(new FileInputStream("src/images/background/flooreStones.jpg"));
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(new FileInputStream("src/images/background/walls.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            if (row > (gp.maxScreenRow - 3)) {
                g2.drawImage(tiles[0].image, x, y, gp.titleSize, gp.titleSize, null);
            }else {
                g2.drawImage(tiles[1].image, x, y, gp.titleSize, gp.titleSize, null);

            }
            col++;
            x+= gp.titleSize;
            if(col == gp.maxScreenCol){
                col=0;
                x = 0;
                row++;
                y+= gp.titleSize;
            }
        }
    }

}
