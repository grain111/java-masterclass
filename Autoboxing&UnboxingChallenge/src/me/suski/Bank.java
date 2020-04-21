package me.suski;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }
    
    public void showData() {
        System.out.println("All " + name + "'s transactions:\n***********");
        for (int i=0; i<branches.size(); i++) {
            branches.get(i).showCustomers();
        }
    }

    public void showBranchData(String name) {
        Branch branch = getBranch(name);
        if (branch != null) {
            branch.showCustomers();
        }
    }

    public boolean addBranch(String name) {
        if (getBranch(name) != null) {
            return false;
        }
        Branch branch = new Branch(name);
        branches.add(branch);
        return true;
    }

    public boolean addTransaction(String branchName, String customerName, double amount) {
        Branch branch = getBranch(branchName);
        if (branch == null) {
            return false;
        }
        boolean res = branch.addTransaction(customerName, amount);
        if (!res) {
            return false;
        }
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double amount) {
        Branch branch = getBranch(branchName);
        if (branch == null) {
            return false;
        }
        boolean res = branch.addCustomer(customerName, amount);
        if (!res) {
            return false;
        }
        return true;
    }

    private Branch getBranch(String name) {
        for (int i=0; i<branches.size(); i++) {
            if (branches.get(i).getName().equals(name)) {
                return branches.get(i);
            }
        }
        return null;
    }
}
