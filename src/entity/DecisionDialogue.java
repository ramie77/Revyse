package entity;

public class DecisionDialogue extends Dialogue {

    int responseIndex;
    int responseNum;

    public DecisionDialogue(String question, int responseNum) {
        super(question);

        this.isQuestion = true;
        this.responseNum = responseNum;
        this.responseIndex = 0;
        this.response = new String[responseNum];
    }
}
