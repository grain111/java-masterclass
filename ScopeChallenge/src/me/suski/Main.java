package me.suski;

import java.util.Scanner;

public class Main {

    private static Scanner x = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter a number: ");
        (new X(x.nextInt())).x();
        x.close();
    }

}
