package entity;

import main.GamePanel;
import main.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Entity {

    GamePanel gP;
    public int worldX, worldY;
    public int speed;
    public int scaleX = 1;
    public int scaleY = 1;

    public BufferedImage up1, up2, down1, down2, down3, left1, left2, right1, right2, shadow;
    public String direction;
    public String name;
    public String imagePath;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    int dialogueIndex = 0;
    int dialogueSetNum = 10;
    int currentDialogueSet = 0;
    DialogueSet[] dialogueSets = new DialogueSet[dialogueSetNum];

    public Entity (GamePanel gP) {

        this.gP = gP;
        this.solidArea.width = gP.tileSize*this.scaleX;
        this.solidArea.height = gP.tileSize*this.scaleY;

        for (int i = 0; i < dialogueSetNum; i++) {
            dialogueSets[i] = new DialogueSet();
        }
    }

    public void setAction() {}
    public void setDialogue() {}

    public void updateDialogue() {

        if (dialogueSets[currentDialogueSet].read && !dialogueSets[currentDialogueSet+1].isEmpty()) {
            currentDialogueSet++;
        }
    }

    public void speak() {

        if (dialogueSets[currentDialogueSet].dialogues[dialogueIndex] != null) {
            gP.uI.currentDialogue = dialogueSets[currentDialogueSet].dialogues[dialogueIndex];
            gP.uI.currentDialogue.name = name;
            gP.uI.currentDialogue.imagePath = imagePath;
            dialogueIndex++;
        } else {
            gP.dialogueState = false;
            gP.decisionState = false;
            gP.canMove = true;
            dialogueIndex = 0;
            dialogueSets[currentDialogueSet].read = true;
        }
        gP.uI.charIndex = 0;
        gP.uI.combinedText = "";
    }

    public void update() {

        collisionOn = false;
        gP.collCheck.checkTile(this);

        spriteCounter++;
        if (spriteCounter > 35) {
            if (spriteNum == 1) {
                spriteNum = 2;
            }

            else if (spriteNum == 2) {
                spriteNum = 3;
            }

            else if (spriteNum == 3) {
                spriteNum = 4;
            }

            else if (spriteNum == 4) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        setDialogue();
    }

    UtilityTool uTool = new UtilityTool();

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch(direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }

                if (spriteNum == 2) {
                    image = up2;
                }
                break;

            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }

                if (spriteNum == 2) {
                    image = down3;
                }

                if (spriteNum == 3) {
                    image = down1;
                }

                if (spriteNum == 4) {
                    image = down2;
                }
                break;

            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }

                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left1;
                }

                if (spriteNum == 4) {
                    image = left2;
                }
                break;

            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }

                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }

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

        if (worldX + gP.tileSize > gP.player.worldX - gP.player.screenX &&
                worldX - gP.tileSize < gP.player.worldX + gP.player.screenX &&
                worldY + gP.tileSize > gP.player.worldY - gP.player.screenY &&
                worldY - gP.tileSize < gP.player.worldY + gP.player.screenY) {

            g2.drawImage(image, screenX, screenY,null);
        }

        else if (gP.player.screenX > gP.player.worldX ||
                gP.player.screenY > gP.player.worldY ||
                rightOffSet > gP.worldWidth - gP.player.worldX ||
                bottomOffSet > gP.worldHeight - gP.player.worldY) {

            g2.drawImage(image, screenX, screenY, null);
        }
    }
}
