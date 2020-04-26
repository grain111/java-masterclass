package me.suski;

public class Main {

    public static void main(String[] args) {

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");


        Team<FootballPlayer> aTeam = new Team<>("Nice");
        aTeam.addPlayer(joe);
//        aTeam.addPlayer(pat);
//        aTeam.addPlayer(beckham);

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cups");
        baseballTeam.addPlayer(pat);

        System.out.println(aTeam.numPlayers());

        Team<SoccerPlayer> brokenTeam = new Team<>("this");
        brokenTeam.addPlayer(beckham);

        

    }
}
