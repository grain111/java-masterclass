package me.suski;

public class Main {

    public static void main(String[] args) {
        int position = calculateHighScorePosition(1000);
        displayHighScorePosition("Bartek", position);

        position = calculateHighScorePosition(900);
        displayHighScorePosition("John", position);

        position = calculateHighScorePosition(400);
        displayHighScorePosition("Max", position);

        position = calculateHighScorePosition(50);
        displayHighScorePosition("Peter", position);
    }

    public static void displayHighScorePosition(String name,
                                                int pos) {
        System.out.println(name +
                " managed to get to position " +
                pos +
                " on high score table.");
    }

    public static int calculateHighScorePosition(int score) {
//        if (score >= 1000) {
//            return 1;
//        } else if (score >= 500) {
//            return 2;
//        } else if (score >= 100) {
//            return 3;
//        }
//        return 4;

        int position = 4;

        if (score >= 1000) {
            position = 1;
        } else if (score >= 500) {
            position = 2;
        } else if (score >= 100) {
            position = 3;
        }

        return position;
}

}
