package me.suski;

public class Main {

    public static void main(String[] args) {

        System.out.println(sumDigits(1111));
    }

    public static int sumDigits(int num) {
        if (num < 10) {
            return -1;
        }
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
