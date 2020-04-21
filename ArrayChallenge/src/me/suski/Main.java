package me.suski;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntArray = getIntegers(10);
        printArray(sortIntegers(myIntArray));


    }

    private static int[] sortIntegers(int[] array) {
        int[] arrayCopy = array.clone();
        int n = arrayCopy.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arrayCopy[j] < arrayCopy[j + 1]) {
                    int temp = arrayCopy[j];
                    arrayCopy[j] = arrayCopy[j + 1];
                    arrayCopy[j + 1] = temp;
                }
            }
        }
        return arrayCopy;
    }

    private static int[] getIntegers(int count) {
        System.out.println("Input " + count + " integers:");
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Integer #" + (i + 1) + " ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
