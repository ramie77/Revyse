package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class NPC_Reaper extends Entity {

    public NPC_Reaper(GamePanel gP) {
        super(gP);

        name = "Reaper";
        direction = "down";
        speed = 1;
        imagePath = "/icon/reaper.png";

        getImage();
        setDialogue();
    }

    public void setDialogue() {

        dialogueSets[0].dialogues[0] = new DecisionDialogue("Are you ready?", 2);
        dialogueSets[0].dialogues[0].response[0] = "Yes";
        dialogueSets[0].dialogues[0].response[1] = "No";
        dialogueSets[0].dialogues[0].isNpc = true;

    }

    public void getImage() {
        try {
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/reaper.png")));
            down1 = uTool.scaleImage(down1, gP.tileSize*scaleX, gP.tileSize*scaleY);
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/reaper2.png")));
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
