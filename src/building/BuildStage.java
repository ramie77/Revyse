package building;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class BuildStage extends Building {

    public BuildStage(GamePanel gP) {
        super(gP);
        name = "Stage";
        scaleX = 4;
        scaleY = 5;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/building/stage.png")));
            image = uTool.scaleImage(image, gP.tileSize*scaleX, gP.tileSize*scaleY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

    public void setDialogue() {

        dialogues[0] = "The stage is set but the performer is absent.";
        dialogues[1] = "Perhaps something went wrong?";
    }

    public void update() {
        super.update();
    }
}
