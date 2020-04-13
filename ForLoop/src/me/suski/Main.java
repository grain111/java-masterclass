package me.suski;

public class Main {

    public static void main(String[] args) {

        for(double i=2; i<9; i++) {
            System.out.println("10,000 at " + i + "% interest is " + String.format("%.2f",calculateInterest(10000d, i)));
        }

        for(double i=8; i>1; i--) {
            System.out.println("10,000 at " + i + "% interest is " + String.format("%.2f",calculateInterest(10000d, i)));
        }

        for(int i=1; i<6; i++) {
            System.out.println("Loop " + i + " hello!");
        }

        int primeFound = 0;
        for(int i=55; i<100; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is prime");
                primeFound++;

                if (primeFound == 100) {
                    break;
                }
            }
        }
    }

    public static double calculateInterest(double amount, double rate) {
        return amount * (rate / 100.0);
    }

    public static boolean isPrime(int n) {
        if (n == 1){
            return false;
        }

        for(int i=2; i<= (long) Math.sqrt(n/2); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
