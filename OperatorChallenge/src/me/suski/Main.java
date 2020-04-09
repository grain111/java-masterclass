package me.suski;

public class Main {

    public static void main(String[] args) {

        double a = 20d;
        double b = 80d;
        boolean c = (((a + b) * 100) % 40d) == 0;
        System.out.println(c);
        if (!c) {
            System.out.println("Got some reminder!");
        }
    }
}
