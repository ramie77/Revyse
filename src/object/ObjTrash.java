package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class ObjTrash extends SuperObject {

    public ObjTrash(GamePanel gP) {
        super(gP);
        name = "Trash";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object/trash.png")));
            image = uTool.scaleImage(image, gP.tileSize*scaleX, gP.tileSize*scaleY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;

        solidAreaDefaultX = gP.tileSize/4;
        solidAreaDefaultY = gP.tileSize/2;
        solidArea.width = gP.tileSize/2;
        solidArea.height = gP.tileSize/2;
    }

    public void setDialogue() {

        dialogues[0] = "It's an empty trash can.";
    }

    public void update() {
        super.update();
    }
}
