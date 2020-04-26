package me.suski;

public class Main {

    public static void main(String[] args) {
        Football team1 = new Football("Team 1");
        Football team2 = new Football("Team 2");
        Football team3 = new Football("Team 3");
        Football team4 = new Football("Team 4");

        Baseball team5 = new Baseball("Baseball team 1");

        League<Football> league = new League<>("Football League");

        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam(team3);
        league.addTeam(team4);

        league.addMatch(team1, team2, 5, 3);
        league.addMatch(team3, team2, 2, 8);
        league.addMatch(team4, team2, 2, 2);
        league.addMatch(team1, team3, 8, 8);
        league.addMatch(team4, team1, 5, 0);
        league.addMatch(team4, team2, 2, 0);

        league.printTable();
    }
}
