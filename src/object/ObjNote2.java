package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class ObjNote2 extends SuperObject {

    public ObjNote2(GamePanel gP) {
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

        dialogues[0] = "\"The Curse of the Black Rose\"";
        dialogues[1] = "\"It's funny how much of our past define us.\"";
        dialogues[2] = "\"Yet we tend to forget them.\"";

    }

    public void update() {
        super.update();
    }
}
