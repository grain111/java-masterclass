package me.suski;

public class Main {

    public static void main(String[] args) {
//        Bank GNB = new Bank("GNB");
//
//        GNB.addBranch("Lublin");
//        GNB.addBranch("Warsaw");
//        GNB.addBranch("Wroclaw");
//
//        GNB.addCustomer("Lublin", "John", 5.25);
//        GNB.addCustomer("Lublin", "Mike", 32.5);
//        GNB.addCustomer("Lublin", "Crag", 8);
//        GNB.addCustomer("Lublin", "Alex", 10);
//        GNB.addCustomer("Wroclaw", "Max", 65);
//        GNB.addCustomer("Wroclaw", "Mike", 98);
//        GNB.addCustomer("Wroclaw", "William", 2);
//        GNB.addCustomer("Wroclaw", "Charles", 36.5);
//        GNB.addCustomer("Wroclaw", "Tom", 25.78);
//        GNB.addCustomer("Warsaw", "Peter", 5);
//        GNB.addCustomer("Warsaw", "John", 5.25);
//        GNB.addCustomer("Warsaw", "Mike", 5.35);
//        GNB.addCustomer("Warsaw", "Anna", 6);
//        GNB.addCustomer("Warsaw", "Kate", 10);
//
//        GNB.addTransaction("Lublin", "John", 10);
//
//        GNB.addTransaction("Lublin", "John", -20);
//
//        GNB.addTransaction("Lublin", "John", -15);
//        GNB.showBranchData("Lublin");

        Bank bank = new Bank("National Australia Bank");

        if(bank.addBranch("Adelaide")) {
            System.out.println("Adelaide branch created");
        }
//
        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);
//
        bank.addBranch("Sydney");
        bank.addCustomer("Sydney", "Bob", 150.54);
//
        bank.addTransaction("Adelaide", "Tim", 44.22);
        bank.addTransaction("Adelaide", "Tim", 12.44);
        bank.addTransaction("Adelaide", "Mike", 1.65);
//
        bank.showBranchData("Adelaide");
        bank.showBranchData("Sydney");
//
        bank.addBranch("Melbourne");
//
        if(!bank.addCustomer("Melbourne", "Brian", 5.53)) {
            System.out.println("Error Melbourne branch does not exist");
        }
//
        if(!bank.addBranch("Adelaide")) {
            System.out.println("Adelaide branch already exists");
        }
//
        if(!bank.addTransaction("Adelaide", "Fergus", 52.33)) {
            System.out.println("Customer does not exist at branch");
        }
//
        if(!bank.addCustomer("Adelaide", "Tim", 12.21)) {
            System.out.println("Customer Tim already exists");
        }



    }
}
