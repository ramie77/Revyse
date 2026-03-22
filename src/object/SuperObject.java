package object;

import entity.Dialogue;
import main.GamePanel;
import main.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    GamePanel gP;

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new  Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public int scaleX = 1;
    public int scaleY = 1;
    public boolean pickable = false;

    int dialogueIndex = 0;
    String[] dialogues = new String[20];

    public SuperObject (GamePanel gP) {

        this.gP = gP;
        setDialogue();

        this.solidArea.width = gP.tileSize*this.scaleX;
        this.solidArea.height = gP.tileSize*this.scaleY;
    }

    public void setDialogue() {}

    public void speak(int i) {

        gP.uI.currentDialogue = new Dialogue(dialogues[dialogueIndex]);

        if (dialogues[dialogueIndex] == null) {
            gP.dialogueState = false;
            gP.canMove = true;

            if (gP.obj[i].pickable) {
                gP.playSoundEffect(2);
                gP.obj[i] = null;}

            dialogueIndex = 0;

        } else {
            dialogueIndex++;
        }

        gP.uI.charIndex = 0;
        gP.uI.combinedText = "";
    }

    public void update() {
        setDialogue();
    }

    UtilityTool uTool = new UtilityTool();

    public void draw(Graphics2D g2, GamePanel gP) {

        int screenX = worldX - gP.player.worldX + gP.player.screenX;
        int screenY = worldY - gP.player.worldY + gP.player.screenY;

        if (gP.player.screenX > gP.player.worldX) {
            screenX = worldX;
        }

        if (gP.player.screenY > gP.player.worldY) {
            screenY = worldY;
        }

        int rightOffSet = gP.screenWidth - gP.player.screenX;
        if (rightOffSet > gP.worldWidth - gP.player.worldX) {
            screenX = gP.screenWidth - (gP.worldWidth - worldX);
        }

        int bottomOffSet = gP.screenHeight - gP.player.screenY;
        if (bottomOffSet > gP.worldHeight - gP.player.worldY) {
            screenY = gP.screenHeight - (gP.worldHeight- worldY);
        }

        if (worldX + gP.tileSize*scaleX > gP.player.worldX - gP.player.screenX &&
                worldX - gP.tileSize*scaleX < gP.player.worldX + gP.player.screenX &&
                worldY + gP.tileSize*scaleY > gP.player.worldY - gP.player.screenY &&
                worldY - gP.tileSize*scaleY < gP.player.worldY + gP.player.screenY) {

            g2.drawImage(image, screenX, screenY, null);
        }

        else if (gP.player.screenX > gP.player.worldX ||
                gP.player.screenY > gP.player.worldY ||
                rightOffSet > gP.worldWidth - gP.player.worldX ||
                bottomOffSet > gP.worldHeight - gP.player.worldY) {

            g2.drawImage(image, screenX, screenY, null);
        }
    }
}
