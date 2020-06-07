package me.suski;

public class BankAccount {
    public enum AccountType {
        CHECKING,
        SAVINGS
    }

    private String firstName;
    private String lastName;
    private double balance;
    private AccountType accountType;


    public BankAccount(String firstName, String lastName, double balance, AccountType accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch) {
        if (amount > 500 && !branch) {
            throw new IllegalArgumentException();
        }
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking() {
        return accountType == AccountType.CHECKING;
    }
}
