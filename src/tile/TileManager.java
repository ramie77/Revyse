package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;

public class TileManager {

    GamePanel gP;
    public Tile[] tile;
    public int mapTileNum[][];
    String filePath;

    public TileManager(GamePanel gP, String filePath) {

        this.gP = gP;
        this.filePath = filePath;

        tile = new Tile[10];
        mapTileNum = new int[gP.maxWorldCol][gP.maxWorldRow];

        getTileImage();
        loadMap(filePath);
    }

    public void getTileImage() {

        setup(0, "blank", false);
        setup(1, "ground", false);
        setup(2, "brick", true);
        setup(3, "grass", false);
        setup(4, "sand", false);
        setup(5, "water", true);
        setup(6, "tree", true);
        setup(7, "his_stone", false);
        setup(8, "tree", false);
        setup(9, "flowers", false);
    }

    public void setup(int index, String imagePath, boolean collision) {

        UtilityTool uTool = new UtilityTool();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/tiles/" + imagePath + ".png")));
            tile[index].image = uTool.scaleImage(tile[index].image, gP.tileSize, gP.tileSize);
            tile[index].collision = collision;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gP.maxWorldCol && row < gP.maxWorldRow) {

                String line = br.readLine();

                while (col <  gP.maxWorldCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gP.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {}
    }

    public void draw(Graphics g2) {

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gP.maxWorldCol && worldRow < gP.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gP.tileSize;
            int worldY = worldRow * gP.tileSize;
            int screenX = worldX - gP.player.worldX + gP.player.screenX;
            int screenY = worldY - gP.player.worldY + gP.player.screenY;

            if (gP.player.screenX > gP.player.worldX) {
                screenX = worldX;
            }

            if (gP.player.screenY > gP.player.worldY) {
                screenY = worldY;
            }

            int rightOffSet = gP.screenWidth - gP.player.screenX;
            if (rightOffSet > gP.worldWidth - gP.player.worldX) {
                screenX = gP.screenWidth - (gP.worldWidth - worldX);
            }

            int bottomOffSet = gP.screenHeight - gP.player.screenY;
            if (bottomOffSet > gP.worldHeight - gP.player.worldY) {
                screenY = gP.screenHeight - (gP.worldHeight- worldY);
            }

            if (worldX + gP.tileSize > gP.player.worldX - gP.player.screenX &&
                    worldX - gP.tileSize < gP.player.worldX + gP.player.screenX &&
                    worldY + gP.tileSize > gP.player.worldY - gP.player.screenY &&
                    worldY - gP.tileSize < gP.player.worldY + gP.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }

            else if (gP.player.screenX > gP.player.worldX ||
                    gP.player.screenY > gP.player.worldY ||
                    rightOffSet > gP.worldWidth - gP.player.worldX ||
                    bottomOffSet > gP.worldHeight - gP.player.worldY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }

            worldCol++;

            if (worldCol == gP.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
