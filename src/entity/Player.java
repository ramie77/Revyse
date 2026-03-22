package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends Entity {

    GamePanel gP;
    KeyHandler kH;

    public final int screenX;
    public final int screenY;
    public int hasBrush = 0;
    float alpha = 1;

    public Player(GamePanel gP, KeyHandler kH) {

        super(gP);
        this.gP = gP;
        this.kH = kH;

        //this.screenX = gP.screenWidth/2 - (gP.tileSize/2); //coord from top left corner
        //this.screenY = gP.screenHeight/2 - (gP.tileSize/2);

        this.screenX = (gP.screenWidth/2) - gP.tileSize/2;
        this.screenY = (gP.screenHeight/2) - gP.tileSize/2;

        solidArea = new Rectangle();
        solidArea.x = 20;
        solidArea.y = 35;
        solidArea.width = 25;
        solidArea.height = 20;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void getPlayerImage() {

        up1 = setup("idle3");
        up2 = setup("idle4");
        down1 = setup("idle");
        down2 = setup("idle2");
        right1 = setup("idle5");
        right2 = setup("idle6");
        left1 = setup("idle7");
        left2 = setup("idle8");
    }

    public BufferedImage setup(String imageName) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/player/" + imageName + ".png")));
            image = uTool.scaleImage(image, gP.tileSize, gP.tileSize);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }

    public void setDefaultValues() {
        worldX = (gP.tileSize * (47/2));
        worldY = gP.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void update() {

        if (kH.upPressed || kH.downPressed || kH.leftPressed || kH.rightPressed || kH.ePressed) {
            if (kH.upPressed) {
                direction = "up";
            }

            if (kH.leftPressed) {
                direction = "left";
            }

            if (kH.downPressed) {
                direction = "down";
            }

            if (kH.rightPressed) {
                direction = "right";
            }

            //CHECK TILE COLLISION
            collisionOn = false;
            int tileIndex = gP.collCheck.checkTile(this);
            interactTile(tileIndex);

            //OBJECT COLLISION
            int objIndex = gP.collCheck.checkObject(this, true);
            pickUpObject(objIndex);

            int npcIndex = gP.collCheck.checkEntity(this, gP.npc);
            interactNPC(npcIndex);

            int buildIndex = gP.collCheck.checkBuild(this, true);
            interactBuild(buildIndex);

            if (!collisionOn && !kH.ePressed) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
            gP.keyHandler.ePressed = false;
        }

        spriteCounter++;
        if (spriteCounter > 35) {
            if (spriteNum == 1) {
                spriteNum = 2;
            }

            else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void interactTile(int i) {

        if (i != 999) {

            switch (i) {
                case 8:
                    //alpha = 0.5F;
            }
        }
    }

    public void pickUpObject (int i) {

        if (i != 999 && gP.keyHandler.ePressed) {
            String objectName = gP.obj[i].name;

            gP.canMove = false;
            gP.dialogueState = true;

            gP.obj[i].speak(i);

            switch (objectName) {
                case "Note":
                    //gP.obj[i].speak(i);
                    //gP.playSoundEffect(1);
                    //gP.uI.gameFinish = true;

                    try {
                        gP.stopMusic();
                    } catch (Exception e) {}

                    break;
                case "Brush":
                    hasBrush++;
                    //NPC_Vyse.updateDialogue(1);

                    //gP.playSoundEffect(2);
                    //gP.uI.showMessage("You got a brush.");
            }
        }
    }

    public void interactNPC (int i) {

        if (i != 999) {

            if (gP.keyHandler.ePressed) {
                gP.canMove = false;
                gP.dialogueState = true;
                gP.npc[i].updateDialogue();
                gP.npc[i].speak();
            }
        }
    }

    public void interactBuild (int i) {

        if (i != 999) {

            if (gP.keyHandler.ePressed) {
                gP.canMove = false;
                gP.dialogueState = true;
                gP.build[i].speak(i);
            }
        }
    }

    public void draw(Graphics2D g2) {

        //g2.setColor(Color.blue);
        //g2.fillRect(x, y, gP.tileSize, gP.tileSize);

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

        int x = screenX;
        int y =  screenY;

        if (screenX > worldX) {
            x = worldX;
        }

        if (screenY > worldY) {
            y = worldY;
        }

        int rightOffSet = gP.screenWidth - screenX;
        if (rightOffSet > gP.worldWidth - worldX) {
            x = gP.screenWidth - (gP.worldWidth - worldX);
        }

        int bottomOffSet = gP.screenHeight - screenY;
        if (bottomOffSet > gP.worldHeight - worldY) {
            y = gP.screenHeight - (gP.worldHeight- worldY);
        }

        //g2.drawImage(shadow, screenX, screenY + 15, gP.tileSize, gP.tileSize, null);
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g2.setComposite(ac);
        g2.drawImage(image, x, y,null);
    }
}
