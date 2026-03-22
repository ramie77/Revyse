package building;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class BuildTower extends Building {

    public BuildTower(GamePanel gP) {
        super(gP);
        name = "Tower";
        scaleX = 3;
        scaleY = 9;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/building/tower.png")));
            image = uTool.scaleImage(image, gP.tileSize*scaleX, gP.tileSize*scaleY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

    public void setDialogue() {

        dialogues[0] = "It's an abandoned stone tower.";
        dialogues[1] = "Apparently there's no visible entrance at the base.";
    }

    public void update() {
        super.update();
    }
}
