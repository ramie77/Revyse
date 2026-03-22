package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class NPC_Bee extends Entity {

    public NPC_Bee(GamePanel gP) {
        super(gP);

        name = "Bee";
        direction = "down";
        speed = 1;
        imagePath = "/icon/bee.png";

        getImage();
        setDialogue();
    }

    public void setDialogue() {

        dialogueSets[0].dialogues[0] = new Dialogue("My friend here is Puppycat.");
        dialogueSets[0].dialogues[0].isNpc = true;
        dialogueSets[0].dialogues[1] = new Dialogue("No, he's not my pet.");
        dialogueSets[0].dialogues[1].isNpc = true;
        dialogueSets[0].dialogues[2]= new Dialogue("Oh wait maybe he actually is..\nhmm..");
        dialogueSets[0].dialogues[2].isNpc = true;

        dialogueSets[1].dialogues[0] = new Dialogue("Should I start charging him rent?");
        dialogueSets[1].dialogues[0].isNpc = true;

    }

    public void getImage() {
        try {
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/bee.png")));
            down1 = uTool.scaleImage(down1, gP.tileSize*scaleX, gP.tileSize*scaleY);
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/bee2.png")));
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
