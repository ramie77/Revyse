package building;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class BuildHouse extends Building {

    public BuildHouse(GamePanel gP) {
        super(gP);
        name = "His house";
        scaleX = 4;
        scaleY = 3;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/building/house.png")));
            image = uTool.scaleImage(image, gP.tileSize*scaleX, gP.tileSize*scaleY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

    public void setDialogue() {


    }

    public void update() {
        super.update();
    }
}
