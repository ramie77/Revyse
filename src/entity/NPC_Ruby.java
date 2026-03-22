package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class NPC_Ruby extends Entity {

    public NPC_Ruby(GamePanel gP) {
        super(gP);

        name = "Ruby";
        direction = "left";
        speed = 1;
        imagePath = "/icon/ruby.png";

        getImage();
        setDialogue();
    }

    public void setDialogue() {

        dialogueSets[0].dialogues[0] = new Dialogue("Is it fun?");
        dialogueSets[0].dialogues[0].isNpc = true;
        dialogueSets[0].dialogues[1] = new Dialogue("Being alone at the edge of the world?");
        dialogueSets[0].dialogues[1].isNpc = true;
    }

    public void getImage() {
        try {
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/ruby.png")));
            left1 = uTool.scaleImage(left1, gP.tileSize*scaleX, gP.tileSize*scaleY);
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/ruby2.png")));
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
