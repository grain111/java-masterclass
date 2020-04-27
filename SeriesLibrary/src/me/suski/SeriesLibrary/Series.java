package me.suski.SeriesLibrary;

public class Series {

    public static int nSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int factorial = 1;
        for (int i = 0; i < n; i++) {
            factorial *= (i + 1);
        }
        return factorial;
    }

    public static int fibonacci(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int temp = a;
            a = a + b;
            b = temp;
        }
        return a;
    }
}
