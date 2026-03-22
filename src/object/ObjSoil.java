package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Objects;

public class ObjSoil extends SuperObject {

    int color;

    public ObjSoil(GamePanel gP,  int var) {
        super(gP);
        name = "Soil";
        scaleY = 3;

        try {
            if (var == 0) {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/soil1.png")));
            } else if (var == 1) {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/soil2.png")));
            } else if (var == 2) {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/soil3.png")));
            }
            image = uTool.scaleImage(image, gP.tileSize*scaleX, gP.tileSize*scaleY);
            solidArea = new Rectangle(0,0, image.getWidth(), image.getHeight());
            collision = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        //collision = true;
    }

    public void update() {
        super.update();
    }
}