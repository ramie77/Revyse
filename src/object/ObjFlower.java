package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Objects;

public class ObjFlower extends SuperObject {

    int color;

    public ObjFlower(GamePanel gP,  int color) {
        super(gP);
        name = "Flower";

        try {
            if (color == 0) {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/red_flower.png")));
            } else if (color == 1) {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/blue_flower.png")));
            } else if (color == 2) {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/yellow_flower.png")));
            }
            image = uTool.scaleImage(image, gP.tileSize*scaleX, gP.tileSize*scaleY);
            solidArea = new Rectangle(0,0, image.getWidth(), image.getHeight());

        } catch (Exception e) {
            e.printStackTrace();
        }
        //collision = true;
    }

    public void update() {
        super.update();
    }
}