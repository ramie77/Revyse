package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gP;

    public boolean upPressed, downPressed, leftPressed, rightPressed, ePressed;
    boolean checkDrawTime = false;
    public KeyHandler(GamePanel gP) {
        this.gP = gP;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (gP.gameState == gP.playState) {

            if (gP.canMove) {
                if (code == KeyEvent.VK_W) {
                    upPressed = true;
                }

                else if (code == KeyEvent.VK_A) {
                    leftPressed = true;
                }

                else if (code == KeyEvent.VK_S) {
                    downPressed = true;
                }

                else if (code == KeyEvent.VK_D) {
                    rightPressed = true;
                }

                else if (code == KeyEvent.VK_ESCAPE) {
                    gP.gameState = gP.pauseState;
                }

                else if (code == KeyEvent.VK_T) {
                    if (!checkDrawTime) {
                        checkDrawTime = true;
                    } else {
                        checkDrawTime = false;
                    }
                }
            }

            if (code == KeyEvent.VK_E) {

                ePressed = true;
            }


        }

        else if (gP.gameState == gP.pauseState) {

            if (code == KeyEvent.VK_ESCAPE) {
                gP.gameState = gP.playState;
            }
        }

        else if (gP.dialogueState) {

            if (code == KeyEvent.VK_E) {

                gP.gameState = gP.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
