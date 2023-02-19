package images.background.tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class TileManager {
    GamePanel gp;
    Tile [] tiles;
    int mapTileNum[][];



    public TileManager(GamePanel gp) {
        this.gp = gp;
       tiles = new Tile[5];
       mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
       getTileImage();
       loadMap("src/images/background/MAPFIRST.txt");
    }
    public void getTileImage(){
        try{
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(new FileInputStream("src/images/background/flooreStones.jpg"));
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(new FileInputStream("src/images/background/walls.jpg"));
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(new FileInputStream("src/images/background/next.jpg"));
            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(new FileInputStream("src/images/background/kratka.jpg"));
            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(new FileInputStream("src/images/background/barrelstoxic.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String map){

        try {
            InputStream in = new FileInputStream(map);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int col = 0;
            int row =0;
            while (col< gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
               while (col < gp.maxScreenCol){
                   String [] nums = line.split(" ");
                   int num = Integer.parseInt(nums[col]);
                   mapTileNum[col][row] = num;
                   col++;
               }
               if(col== gp.maxScreenCol){
                   col = 0;
                   row++;
               }

            }
            br
                    .close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            int tileNum = mapTileNum[col][row];
//            if (row > (gp.maxScreenRow - 3)) {
//                g2.drawImage(tiles[0].image, x, y, gp.titleSize, gp.titleSize, null);
//            }else {
//                g2.drawImage(tiles[1].image, x, y, gp.titleSize, gp.titleSize, null);
//
//            }
                            g2.drawImage(tiles[tileNum].image, x, y, gp.titleSize, gp.titleSize, null);

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

    public int[][] getMapTileNum() {
        return mapTileNum;
    }
}
