package building;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class BuildTruck extends Building {

    public BuildTruck(GamePanel gP) {
        super(gP);
        name = "Truck";
        scaleX = 5;
        scaleY = 2;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/building/truck.png")));
            image = uTool.scaleImage(image, gP.tileSize*scaleX, gP.tileSize*scaleY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

    public void setDialogue() {

        dialogues[0] = "It's blocking the exit.";
    }

    public void update() {
        super.update();
    }
}
