package me.suski;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();
    private double balance = 0.0;

    public Customer(String name, double initialTransaction) {
        this.name = name;
        addTransaction(initialTransaction);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactions() {
        System.out.println("  + " + name + "'s transactions: ");
        for (int i=0; i<transactions.size(); i++) {
//            System.out.println("    * " + transactions.get(i).intValue());
            System.out.println("    * " + transactions.get(i));
        }
    }

    public boolean addTransaction(double amount) {
        double newBalance = balance + amount;
        if (newBalance < 0) {
            return false;
        } else {
//            transactions.add(Double.valueOf(amount));
            transactions.add(amount);
            balance = newBalance;
            return true;
        }
    }
}
