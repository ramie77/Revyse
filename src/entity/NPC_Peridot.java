package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class NPC_Peridot extends Entity {
    public NPC_Peridot(GamePanel gP) {
        super(gP);

        direction = "down";
        speed = 1;
        name = "Peridot";
        imagePath = "/icon/peridot.png";

        getImage();
        setDialogue();
    }

    public void setDialogue() {

        dialogueSets[0].dialogues[0] = new Dialogue("The customs of this planet's species is so weird.");
        dialogueSets[0].dialogues[0].isNpc = true;
        dialogueSets[0].dialogues[1] = new Dialogue("How can you left someone on \"read\",\nespecially with your friend??");
        dialogueSets[0].dialogues[1].isNpc = true;
        dialogueSets[0].dialogues[2] = new Dialogue("Perhaps my calculation to stay on \nthis planet might have an error..");
        dialogueSets[0].dialogues[2].isNpc = true;
    }

    public void getImage() {
        try {
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/peridot.png")));
            down1 = uTool.scaleImage(down1, gP.tileSize*scaleX, gP.tileSize*scaleY);
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/peridot2.png")));
            down2 = uTool.scaleImage(down2, gP.tileSize*scaleX, gP.tileSize*scaleY);
            down3 = down2;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {}

    public void speak() {

        super.speak();
    }
}
