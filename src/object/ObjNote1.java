package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class ObjNote1 extends SuperObject {

    public ObjNote1(GamePanel gP) {
        super(gP);

        name = "Note1";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/note.png")));
            image = uTool.scaleImage(image, gP.tileSize*scaleX, gP.tileSize*scaleY);

        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

    public void setDialogue() {

        dialogues[0] = "\"After everything I done for him,\n for everyone..\"";
        dialogues[1] = "\"How could I be so blind?\n All I wanted is to do good,\"";
        dialogues[2] = "\"Isn't that's all what worth fighting for?\"";
    }

    public void update() {
        super.update();
    }
}
