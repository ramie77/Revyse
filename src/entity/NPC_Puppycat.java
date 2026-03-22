package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class NPC_Puppycat extends Entity {

    public NPC_Puppycat(GamePanel gP) {
        super(gP);

        name = "Puppycat";
        direction = "down";
        speed = 1;
        imagePath = "/icon/puppycat.png";

        getImage();
        setDialogue();

        solidAreaDefaultY = gP.tileSize/3;
    }

    public void setDialogue() {

        dialogueSets[0].dialogues[0] = new Dialogue("*Funny noises*");
        dialogueSets[0].dialogues[0].isNpc = true;
        dialogueSets[0].dialogues[1] = new Dialogue("(Is it a dog or a cat?)");
    }

    public void getImage() {
        try {
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/puppycat.png")));
            down1 = uTool.scaleImage(down1, gP.tileSize*scaleX, gP.tileSize*scaleY);
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/puppycat2.png")));
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
