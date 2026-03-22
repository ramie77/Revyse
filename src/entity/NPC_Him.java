package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class NPC_Him extends Entity {

    public NPC_Him(GamePanel gP) {
        super(gP);

        name = "Him";
        direction = "left";
        speed = 1;
        imagePath = "/icon/him.png";

        getImage();
        setDialogue();
    }

    public void setDialogue() {

        dialogueSets[0].dialogues[0] = new Dialogue("Have you ever thought of going back in time?\nAnd change the bad decisions you made?");
        dialogueSets[0].dialogues[0].isNpc = true;
        dialogueSets[0].dialogues[1] = new Dialogue("But that's not a healthy way to think about it\ndoesn't it?");
        dialogueSets[0].dialogues[1].isNpc = true;
        dialogueSets[0].dialogues[2] = new Dialogue("How would you know it's a bad decision\nif you never experienced it?");
        dialogueSets[0].dialogues[2].isNpc = true;
    }

    public void getImage() {
        try {
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/him.png")));
            left1 = uTool.scaleImage(left1, gP.tileSize*scaleX, gP.tileSize*scaleY);
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/him2.png")));
            left2 = uTool.scaleImage(left2, gP.tileSize*scaleX, gP.tileSize*scaleY);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {}

    public void speak() {

        super.speak();
    }
}
