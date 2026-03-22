package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import entity.Dialogue;
import object.ObjNote1;

import javax.imageio.ImageIO;

public class UI {

    GamePanel gP;
    Graphics2D g2;
    Font arial_20;
    Font arial_40P;
    Font arial_30;
    BufferedImage image;
    public boolean messageOn = false;
    public String message = "";
    public int messageCounter = 0;
    public boolean gameFinish = false;
    public Dialogue currentDialogue;
    public int charIndex = 0;
    public String combinedText = "";
    UtilityTool uTool;

    public UI(GamePanel gP) {

        this.gP = gP;
        arial_20 = new Font("arial", Font.PLAIN, 20);
        arial_30 = new Font("arial", Font.PLAIN, 30);
        arial_40P = new Font("arial", Font.BOLD, 40);
        this.uTool = new UtilityTool();
    }

    public void showMessage(String text) {

        message  = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) throws IOException {

        this.g2 = g2;

        g2.setFont(arial_20);
        g2.setColor(Color.white);

        if (gP.gameState == gP.playState) {
            if (gameFinish) {

                g2.setFont(arial_40P); //do not instantiate in loop
                g2.setColor(Color.white);

                String text;
                int textLength;
                int x;
                int y;

                text = "Is this really the end?";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

                x = gP.screenWidth/2 - textLength/2;
                y = gP.screenHeight/2 - (gP.tileSize/2*2);

                g2.drawString(text, x, y);

                gP.gameThread = null;

            } else {
                g2.setFont(arial_20); //do not instantiate in loop
                g2.setColor(Color.white);
                //g2.drawImage(noteImage, gP.tileSize, gP.tileSize, null);
                //g2.drawString("x " + gP.player.hasNote, 50, 50);

                //g2.drawString("World: " + gP.player.worldX + "," + gP.player.worldY, 25, 50);

                if (messageOn) {
                    g2.setFont(g2.getFont().deriveFont(20));
                    g2.drawString(message, 25, 75);

                    messageCounter++;

                    if (messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;
                    }
                }
            }
        }

        if  (gP.gameState == gP.pauseState) {

            drawPauseScreen();
        }

        if (gP.dialogueState) {

            drawDialogueScreen();

            if (currentDialogue.isQuestion) {

                gP.decisionState = true;
                drawDecisionScreen();
            }
        }
    }

    private void drawDecisionScreen() {

        int x = gP.tileSize*10;
        int y = gP.tileSize*4 - (gP.tileSize/2);
        int width = gP.tileSize*4;
        int height = gP.tileSize*currentDialogue.response.length;
        drawSubWindow(x, y, width, height);

        g2.setFont(arial_20);

        int textX = x + width/2 - gP.tileSize/2;
        int textY = y + height/2 - gP.tileSize/6;
        int stepY = gP.tileSize/2;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/ui/arrow.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String choice : currentDialogue.response) {

            if (currentDialogue.responseIndex == uTool.findIndex(currentDialogue.response, choice)) {
                g2.drawImage(image, textX, textY*(currentDialogue.responseIndex+1), gP.tileSize/2, gP.tileSize/2,  null);
            }

            g2.drawString(choice, textX, textY);
            textY += stepY;
        }

        /**
        textY = y + height/2 - gP.tileSize/6;
        int imageX = gP.tileSize*11;
        int imageY = textY + stepY;
        g2.drawImage(image, imageX, imageY, gP.tileSize/2, gP.tileSize/2,  null);
         **/
    }

    public void drawPauseScreen() {

        String text = "PAUSED";
        int x;
        int y;
        int textLength;

        g2.setFont(arial_40P);
        textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gP.screenWidth/2 - textLength/2;
        y = gP.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen() throws IOException {

        int x = gP.tileSize*2;
        int y = gP.tileSize/2;
        int width = gP.screenWidth - gP.tileSize*4;
        int height = gP.tileSize*3;
        drawSubWindow(x, y, width, height);

        x += gP.tileSize;
        y += gP.tileSize;

        char[] characters = currentDialogue.text.toCharArray();

        if (combinedText.length() < characters.length) {
            String s = String.valueOf(characters[charIndex]);
            combinedText += s;
            charIndex++;
        }

        if (currentDialogue.isNpc) {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(currentDialogue.imagePath)));
            g2.drawImage(image, x, y-35, gP.tileSize*2, gP.tileSize*2, null);
            x = gP.tileSize*6 - 20;
            //g2.drawString(currentDialogue.name+":", x, y);
            //y += 28;
        }

        for (String line : combinedText.split("\n")) {

            g2.drawString(line, x, y);
            y += 28;
        }

    }

    public void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0, 0,0, 210); //alpha value
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(c);
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }
}
