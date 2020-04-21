package me.suski;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter count parameter: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid Input. Exiting...");
            return;
        }
        int count = scanner.nextInt();
        int[] array = inputIntegers(count);
        System.out.println("Minimum value in array " + Arrays.toString(array) +
                " is " + findMin(array));

    }

    public static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int[] inputIntegers(int count) {
        int[] array = new int[count];
        int counter = 0;
        System.out.println("Enter " + count + " integers");
        while (counter < count) {
            System.out.print("Enter integer #" + (counter + 1) + ": ");
            if (scanner.hasNextInt()) {
                array[counter] = scanner.nextInt();
                counter++;
            }
            scanner.nextLine();
        }
        System.out.println("Entered " + Arrays.toString(array));
        return array;
    }
}
