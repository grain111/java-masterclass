package me.suski;

public class Main {

    public static void main(String[] args) {

        int newScore = calculateScore("Bartek", 500);
        System.out.println("New score is " + newScore);

        calculateScore(75);

        calculateScore();

        double a = calcFeetAndInchesToCentimeters(5, 11);
        System.out.println("5 feet and 11 inches is " + a + " cm");

        a = calcFeetAndInchesToCentimeters(71);
        System.out.println("71 inches is " + a + " cm");
    }

    public static int calculateScore(String name, int score) {
        System.out.println("Player " + name + " scored " + score + " points.");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score + " points.");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score");
        return 0;
    }

    public static double calcFeetAndInchesToCentimeters(int feet, int inches) {
        if (feet < 0 || inches < 0 || inches > 12) {
            return -1;
        }
        return (feet * 12 + inches) * 2.54d;
    }

    public static double calcFeetAndInchesToCentimeters(int inches) {
        if (inches < 0) {
            return -1;
        }
        return inches * 2.54d;
    }
}
