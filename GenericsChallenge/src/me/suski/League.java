package me.suski;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

    private String name;
    private ArrayList<T> teams = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public void addTeam(T team) {
        if (!teams.contains(team)) {
            teams.add(team);
        } else {
            System.out.println("Team already at the league.");
        }
    }

    public void printTable() {
        Collections.sort(teams);
        for (int i=0; i<teams.size(); i++) {
            System.out.println((i + 1) + ". " + teams.get(i).getName() + " - " + teams.get(i).calculateScore());
        }
    }

    public void addMatch(T team1, T team2, int score1, int score2) {
        if (!teams.contains(team1) || !teams.contains(team2)) {
            System.out.println("One of the teams is not in the league. Use league.add()");
            return;
        }

        if (score1 > score2) {
            team1.addGamesWon();
            team2.addGamesLost();
        } else if (score1 < score2) {
            team1.addGamesLost();
            team2.addGamesWon();
        } else {
            team1.addGamesDrawen();
            team2.addGamesDrawen();
        }

    }
}
