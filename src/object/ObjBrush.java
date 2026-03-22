package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class ObjBrush extends SuperObject {

    public ObjBrush(GamePanel gP) {
        super(gP);
        name = "Brush";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/brush.png")));
            image = uTool.scaleImage(image, gP.tileSize*scaleX, gP.tileSize*scaleY);

        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

    public void setDialogue() {

        dialogues[0] = "You got a brush.";
    }

    public void update() {
        super.update();
    }
}
