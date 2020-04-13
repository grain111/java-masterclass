package me.suski;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int number = 5;
        int count = 2;
        long avg = Math.round((double) (number / count));

        System.out.println(avg);

//        Scanner scanner = new Scanner(System.in);
//
//        int min = 0;
//        int max = 0;
//        int number;
//        boolean firstRun = true;
//
//        while(true) {
//            System.out.println("Enter a number: ");
//            if(scanner.hasNextInt()) {
//                number = scanner.nextInt();
//                if (firstRun) {
//                    min = number;
//                    max = number;
//                    firstRun = false;
//                } else {
//                    min = number < min ? number : min;
//                    max = number > max  ? number : max;
//                }
//                scanner.nextLine();
//            } else {
//                break;
//            }
//        }
//
//        System.out.println("Min value: " + min + " Max value: " + max);
//        scanner.close();
    }
}
