package me.suski;

public class Main {

    public static void main(String[] args) {

        byte a = 10;
        short b = 50;
        int c = 40;
        long d = 50000 + 10 * (a + b + c);
        System.out.println(d);

        short e = (short) (50000 + 10 * (a + b + c));
    }
}
