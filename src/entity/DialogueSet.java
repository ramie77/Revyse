package entity;

public class DialogueSet {

    public boolean isNpc;
    public boolean read;
    public Dialogue[] dialogues;

    public DialogueSet() {

        this.isNpc = false;
        this.read = false;
        this.dialogues = new Dialogue[10];
    }

    public boolean isEmpty() {
        return this.dialogues[0] == null;
    }
}
