package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class ObjBoard extends SuperObject {

    public ObjBoard(GamePanel gP) {
        super(gP);
        name = "Board";
        scaleX = 2;
        scaleY = 2;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/board.png")));
            image = uTool.scaleImage(image, gP.tileSize*scaleX, gP.tileSize*scaleY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;

        solidArea.width = gP.tileSize*scaleX;
        solidArea.height = gP.tileSize*scaleY;
    }

    public void setDialogue() {

        dialogues[0] = "To-Do List:";
        dialogues[1] = "-Refine dialogue sets";
        dialogues[2] = "-Start menu + options";
        dialogues[3] = "-A cohesive storyline";
        dialogues[4] = "-Improve tile design";
        dialogues[5] = "-Generalise item sprite + inventory system";
        dialogues[6] = "-Sprite animation";
    }

    public void update() {
        super.update();
    }
}
