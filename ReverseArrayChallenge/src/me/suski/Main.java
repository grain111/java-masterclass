package me.suski;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,20};
        System.out.println("Non reversed array " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("Non reversed array " + Arrays.toString(arr));
    }

    public static void reverse(int[] array) {
        int [] temp = array.clone();
        for(int i=0; i<array.length; i++) {
            array[i] = temp[array.length - i - 1];
        }
    }
}
