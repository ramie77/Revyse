package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class NPC_Florez extends Entity {

    public NPC_Florez(GamePanel gP) {
        super(gP);

        name = "Florez";
        direction = "down";
        speed = 1;
        imagePath = "/icon/florez.png";

        getImage();
        setDialogue();
    }

    public void setDialogue() {

        dialogueSets[0].dialogues[0] = new Dialogue("You can't force a plant to grow.");
        dialogueSets[0].dialogues[0].isNpc = true;
        dialogueSets[0].dialogues[1] = new Dialogue("It takes patience and effort.");
        dialogueSets[0].dialogues[1].isNpc = true;
        dialogueSets[0].dialogues[2] = new Dialogue("Just like the bonds we made.");
        dialogueSets[0].dialogues[2].isNpc = true;
    }

    public void getImage() {
        try {
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/florez.png")));
            down1 = uTool.scaleImage(down1, gP.tileSize*scaleX, gP.tileSize*scaleY);
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/florez2.png")));
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
