package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class NPC_Nomu extends Entity {

    public NPC_Nomu(GamePanel gP) {
        super(gP);

        direction = "down";
        speed = 1;
        name = "Nomu";
        imagePath = "/icon/nomu.png";

        getImage();
        setDialogue();

    }

    public void setDialogue() {

        dialogueSets[0].dialogues[0] = new Dialogue("Hi there!\nWelcome to Revyse!");
        dialogueSets[0].dialogues[0].isNpc = true;
        dialogueSets[0].dialogues[1] = new Dialogue("There's not much to do here.. yet.");
        dialogueSets[0].dialogues[1].isNpc = true;
        dialogueSets[0].dialogues[2] = new Dialogue("But trust our dev! He's trying his best!");
        dialogueSets[0].dialogues[2].isNpc = true;
        dialogueSets[0].dialogues[3] = new Dialogue("And that's more important than\nbeing the best!");
        dialogueSets[0].dialogues[3].isNpc = true;

        dialogueSets[1].dialogues[0] = new Dialogue("Have you met everyone here?");
        dialogueSets[1].dialogues[0].isNpc = true;
        dialogueSets[1].dialogues[1] = new Dialogue("We are all pieces of our dev's mind.");
        dialogueSets[1].dialogues[1].isNpc = true;
        dialogueSets[1].dialogues[2] = new Dialogue("Most you see here are \"good\", \nsince he keeps the \"bad\" ones away..");
        dialogueSets[1].dialogues[2].isNpc = true;
        dialogueSets[1].dialogues[3] = new Dialogue("There's also some dev's notes hidden away\nin this world..");
        dialogueSets[1].dialogues[3].isNpc = true;
    }

    public void getImage() {
        try {
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/nomu.png")));
            down1 = uTool.scaleImage(down1, gP.tileSize*scaleX, gP.tileSize*scaleY);
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/nomu2.png")));
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
