package entity;

import java.awt.image.BufferedImage;

public class Dialogue {

    public String text;
    public boolean isNpc;
    public String name;
    public String imagePath;
    public boolean isQuestion;
    public String[] response;
    public int responseIndex;

    public Dialogue(String text) {

        this.text = text;
        this.isNpc = false;
        this.name = "";
        this.imagePath = "";
        this.isQuestion = false;
    }
}
