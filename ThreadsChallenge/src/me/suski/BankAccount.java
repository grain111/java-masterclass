package me.suski;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private String accountNumber;
    private ReentrantLock lock = new ReentrantLock();

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

     public void deposit(double amt) {
        boolean status = false;
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    status = true;
                    balance += amt;
                    System.out.printf("Depositing %.2f, current balance is %.2f\n",
                            amt, balance);
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
         System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amt) {
        boolean status = false;
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    status = true;
                    balance -= amt;
                    System.out.printf("Withdrawing %.2f, current balance is %.2f\n",
                            amt, balance);
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Transaction status = " + status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.printf("Account number = %s\n",
                accountNumber);
    }
}
