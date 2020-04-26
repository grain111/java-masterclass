package me.suski;

public class Baseball extends Team {

    public Baseball(String name) {
        super(name);
    }

    @Override
    public int calculateScore() {
        return getWon() + getDrawen() - getLost();
    }
}
