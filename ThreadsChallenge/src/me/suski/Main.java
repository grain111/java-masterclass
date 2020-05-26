package me.suski;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(
                1000,
                "12345-678");

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300);
                account.withdraw(50);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100);
            }
        }).start();

    }
}
