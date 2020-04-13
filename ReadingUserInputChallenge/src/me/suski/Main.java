package me.suski;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;

        while(count < 10) {
            System.out.println("Enter number #" + (count + 1) + ":");
            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
                count++;
            } else {
                System.out.println("Invalid number");
            }
            scanner.nextLine();
        }
        scanner.close();
        System.out.println("Sum of numbers = " + sum);
    }
}
