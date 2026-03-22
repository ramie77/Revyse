package building;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class BuildHotDog extends Building {

    public BuildHotDog(GamePanel gP) {
        super(gP);
        name = "Hot Dog Stand";
        scaleX = 2;
        scaleY = 2;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/building/hotdogstand.png")));
            image = uTool.scaleImage(image, gP.tileSize*scaleX, gP.tileSize*scaleY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

    public void setDialogue() {

        dialogues[0] = "(There's no one working here at the moment.)";
        dialogues[1] = "(Maybe you should come back later.)";
    }

    public void update() {
        super.update();
    }
}
