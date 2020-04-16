package me.suski;

public class Account {
    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private int phone;

    public Account() {
        this(0, 0d, "John", "noemail", 0);
        System.out.println("Empty constructor called");
    }

    public Account(String customerName, String email, int phone) {
        this(999, 52, customerName, email, phone);

    }

    public Account(int accountNumber, double balance, String customerName,
                   String email, int phone) {
        System.out.println("Constructor with parameters called");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void deposit(double amount) {
        System.out.println("Deposited " + amount);
        this.balance += amount;
    }

    public void withdrawal(double amount) {
        if (amount <= this.balance) {
            System.out.println("Withdrawn $" + amount);
            this.balance -= amount;
        } else {
            System.out.println("Not enough funds");
        }
    }
}
