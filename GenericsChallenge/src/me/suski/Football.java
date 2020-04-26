package me.suski;

public class Football extends Team {
    public Football(String name) {
        super(name);
    }

    @Override
    public int calculateScore() {
        return getWon() * 2 + getDrawen();
    }
}
