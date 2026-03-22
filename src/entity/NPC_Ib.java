package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class NPC_Ib extends Entity {
    public NPC_Ib(GamePanel gP) {
        super(gP);

        direction = "down";
        speed = 1;
        name = "Red-eyed Girl";
        imagePath = "/icon/ib.png";


        getImage();
        setDialogue();

        solidAreaDefaultY = gP.tileSize/3;
    }

    public void setDialogue() {

        dialogueSets[0].dialogues[0] = new Dialogue("It's a little girl with blood red eyes.");
        dialogueSets[0].dialogues[0] = new Dialogue("The blue flower seems dull but it's calm and gentle.");
        dialogueSets[0].dialogues[1].isNpc = true;
        dialogueSets[0].dialogues[2]= new Dialogue("The yellow flower is bright and attractive,\nbut it seems off.");
        dialogueSets[0].dialogues[2].isNpc = true;
    }

    public void getImage() {
        try {
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/ib.png")));
            down1 = uTool.scaleImage(down1, gP.tileSize*scaleX, gP.tileSize*scaleY);
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/ib2.png")));
            down2 = uTool.scaleImage(down2, gP.tileSize*scaleX, gP.tileSize*scaleY);
            down3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/ib2.png")));
            down3 = uTool.scaleImage(down3, gP.tileSize*scaleX, gP.tileSize*scaleY);
            //down3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/ib3.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {}

    public void speak() {

        super.speak();
    }
}
