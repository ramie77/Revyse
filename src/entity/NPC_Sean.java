package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class NPC_Sean extends Entity {
    public NPC_Sean(GamePanel gP) {
        super(gP);

        direction = "down";
        speed = 1;
        name = "Sean";
        imagePath = "/icon/sean.png";


        getImage();
        setDialogue();
    }

    public void setDialogue() {

        dialogueSets[0].dialogues[0] = new Dialogue("Guess we're all stuck in some kind of a purgatory, eh?");
        dialogueSets[0].dialogues[0].isNpc = true;
        dialogueSets[0].dialogues[1] = new Dialogue("So much for a purrgatory blues, get it?");
        dialogueSets[0].dialogues[1].isNpc = true;

        /**
        dialogueSets[1].dialogues[0] = new Dialogue("I get that you miss him real bad.");
        dialogueSets[1].dialogues[0].isNpc = true;
        dialogueSets[1].dialogues[1] = new Dialogue("But I'm sure he's doing alright, cus he's him.");
        dialogueSets[1].dialogues[1].isNpc = true;
        dialogueSets[1].dialogues[2] = new Dialogue("And that's what matters.");
        dialogueSets[1].dialogues[2].isNpc = true;
         **/
    }

    public void getImage() {
        try {
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/sean.png")));
            down1 = uTool.scaleImage(down1, gP.tileSize*scaleX, gP.tileSize*scaleY);
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/sean2.png")));
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
