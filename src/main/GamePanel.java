package main;

import building.Building;
import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable {
    public final int originalTileSize = 16; //16x16 tile
    final int scale = 4;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //WORLD SETTINGS
    public final int maxWorldCol = 48;
    public final int maxWorldRow = 36;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS  = 60;

    //TileManager backTileM = new TileManager(this, "/maps/level0b.txt");
    TileManager tileM = new TileManager(this, "/maps/wm0.txt");
    public KeyHandler keyHandler = new KeyHandler(this);
    SoundManager musicM = new SoundManager();
    SoundManager soundM = new SoundManager();

    public CollisionChecker collCheck = new CollisionChecker(this);
    public AssetSetter setter = new AssetSetter(this);
    public Player player = new Player(this, keyHandler);
    public SuperObject[] obj = new SuperObject[20];
    public Entity[] npc = new Entity[20];
    public Building[] build = new Building[20];
    public UI uI = new UI(this);

    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public boolean dialogueState = false;
    public boolean decisionState = false;
    public boolean canMove = true;

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true); //focused to receive key input
    }

    public void setupGame() {
        setter.setObject();
        setter.setBuilding();
        setter.setNPC();
        gameState = playState;

        //playMusic(0);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = (double) 1000000000 / FPS; //0.01667 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {

            //System.out.println("The game loop is running");
            //long currentTime = System.nanoTime();

            //30 fps -> 30 update & paint per second
            //UPDATE information
            update();

            //DRAW screen
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime); //sleep pauses the game loop in milli s
                nextDrawTime += + drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() { //detect changes

        if (gameState == playState) {
            player.update();

            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].update();
                }
            }

            for (int i = 0; i < build.length; i++) {
                if (build[i] != null) {
                    build[i].update();
                }
            }
        }

        if (gameState == pauseState) {

        }

    }

    public void paintComponent(Graphics g) { //show changes
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //Debug
        long drawStart = 0;
        if (keyHandler.checkDrawTime) {
            drawStart = System.nanoTime();
        }

        //backTileM.draw(g2);
        tileM.draw(g2);
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }

        for (int i = 0; i < npc.length; i++) {
            if (npc[i] != null) {
                npc[i].draw(g2);
            }
        }

        for (int i = 0; i < build.length; i++) {
            if (build[i] != null) {
                build[i].draw(g2, this);
            }
        }

        player.draw(g2);

        try {
            uI.draw(g2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (keyHandler.checkDrawTime) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + passed, 10, 400);
            System.out.println("Draw Time: " + passed);
        }

        g2.dispose(); //dispose this graphic and release system resources
    }

    public void playMusic(int i) {
        musicM.setFile(i);
        musicM.play();
        musicM.loop();
    }

    public void stopMusic() {
        musicM.stop();
    }

    public void playSoundEffect(int i) {
        soundM.setFile(i);
        soundM.play();
    }
}
