package me.suski;

import java.util.ArrayList;

public class Account {

    private String name;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.transactions.add(amount);
            this.balance+=amount;
            System.out.println(amount + " deposited, current balance is " + balance);
        } else {
            System.out.println("Cannot deposit negative amount");
        }
    }

    public void withdrawal(int amount) {
//        amount = amount * -1;
        int withdrawal = amount * -1;
        if (withdrawal < 0) {
            this.transactions.add(withdrawal);
            this.balance += withdrawal;
            System.out.println(amount + " withdrawn, current balance is " + balance);
        } else {
            System.out.println("Cannot withdraw negative  amount");
        }
    }

    public void calculateBalance() {
        int balance = 0;

        for (int i : this.transactions) {
            balance += i;
        }

        System.out.println("Calculated balance is " + this.balance);
    }
}
