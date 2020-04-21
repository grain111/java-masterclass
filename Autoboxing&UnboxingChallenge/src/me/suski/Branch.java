package me.suski;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void showCustomers() {
        System.out.println(name + "'s customers:");
        for (int i=0; i<customers.size(); i++) {
            System.out.println();
            customers.get(i).showTransactions();
        }
    }

    public boolean addTransaction(String name, double amount) {
        Customer customer = getCustomer(name);
        if (customer == null){
            return false;
        }
        boolean res = customer.addTransaction(amount);
        if (!res) {
            System.out.println("Operation unsuccessful. Not enough money.");
            return false;
        }
        return true;
    }

    public boolean addCustomer(String name, double value) {
        if (value < 0) {
            return false;
        }
        if (getCustomer(name) != null) {
            return false;
        }
        customers.add(new Customer(name, value));
        return true;
    }

    public Customer getCustomer(String name) {
        for (int i=0; i<customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return customers.get(i);
            }
        }
        return null;
    }
}
