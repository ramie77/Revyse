package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class ObjArt extends SuperObject {

    public ObjArt(GamePanel gP) {
        super(gP);
        name = "Art";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/art.png")));
            image = uTool.scaleImage(image, gP.tileSize*scaleX, gP.tileSize*scaleY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

    public void setDialogue() {

        dialogues[0] = "Someone was painting here.";
        dialogues[1] = "It looks like a metallic rose.";
    }

    public void update() {
        super.update();
    }
}
