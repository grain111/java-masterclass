package me.suski;

public abstract class Team<T extends Team> implements Comparable<Team<T>> {

    private String name;
    private int won = 0;
    private int lost = 0;
    private int drawen = 0;
    private int played = 0;

    public Team(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Team<T> other) {
        if (this.calculateScore() > other.calculateScore()) {
            return -1;
        } else if (this.calculateScore() < other.calculateScore()) {
            return 1;
        } else {
            return 0;
        }
    }

    public abstract int calculateScore();

    public String getName() {
        return name;
    }

    public void addGamesWon() {
        this.won++;
        this.played++;
    }

    public void addGamesLost() {
        this.lost++;
        this.played++;
    }

    public void addGamesDrawen() {
        this.drawen++;
        this.played++;
    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public int getDrawen() {
        return drawen;
    }

    public int getPlayed() {
        return played;
    }
}
