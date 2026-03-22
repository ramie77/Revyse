package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class NPC_Vyse extends Entity {

    public NPC_Vyse(GamePanel gP) {
        super(gP);

        name = "Vyse";
        direction = "down";
        speed = 1;
        imagePath = "/icon/vyse.png";

        getImage();
        setDialogue();


    }

    public void updateDialogue() {

        if (dialogueSets[0].read && !dialogueSets[1].read) {
            if (gP.player.hasBrush > 0) {
                currentDialogueSet = 1;
            }
        }

        else if (dialogueSets[1].read) {
            currentDialogueSet = 2;
        }
    }

    public void setDialogue() {

        dialogueSets[0].dialogues[0] = new Dialogue("Another bad day, huh?");
        dialogueSets[0].dialogues[0].isNpc = true;
        dialogueSets[0].dialogues[1] = new Dialogue("Well, there's always time to try again.");
        dialogueSets[0].dialogues[1].isNpc = true;
        dialogueSets[0].dialogues[2] = new Dialogue("We'll be here as long as you like.");
        dialogueSets[0].dialogues[2].isNpc = true;

        dialogueSets[1].dialogues[0] = new Dialogue("Oh, why thank you.");
        dialogueSets[1].dialogues[0].isNpc = true;
        dialogueSets[1].dialogues[1] = new Dialogue("I can go back to painting now.");
        dialogueSets[1].dialogues[1].isNpc = true;
        dialogueSets[1].dialogues[2] = new Dialogue("Feel free to see me in the meadow.");
        dialogueSets[1].dialogues[2].isNpc = true;

        dialogueSets[2].dialogues[0] = new Dialogue("You know what, I'll tell you a secret.");
        dialogueSets[2].dialogues[0].isNpc = true;
        dialogueSets[2].dialogues[1] = new Dialogue("Some of these trees are not what they seem.");
        dialogueSets[2].dialogues[1].isNpc = true;
    }

    public void getImage() {
        try {
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/vyse.png")));
            down1 = uTool.scaleImage(down1, gP.tileSize*scaleX, gP.tileSize*scaleY);
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/vyse2.png")));
            down2 = uTool.scaleImage(down2, gP.tileSize*scaleX, gP.tileSize*scaleY);
            down3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/vyse3.png")));
            down3 = uTool.scaleImage(down3, gP.tileSize*scaleX, gP.tileSize*scaleY);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {}

    public void speak() {

        super.speak();
    }
}
