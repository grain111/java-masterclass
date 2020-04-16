package me.suski;

public class Main {

    public static void main(String[] args) {

        Account acc1 = new Account(1, 58.36, "John",
                                    "john@john.com", 123545678);
//        acc1.setAccountNumber(1);
//        acc1.setBalance(58.36);
//        acc1.setCustomerName("John");
//        acc1.setEmail("john@john.com");
//        acc1.setPhone(12345678);

        System.out.println("Account number is " + acc1.getAccountNumber());
        System.out.println("Current balance is " + acc1.getBalance());
        System.out.println("Account is owned by " + acc1.getCustomerName());
        System.out.println("Owners email address " + acc1.getEmail());
        System.out.println("Owners phone number " + acc1.getPhone());

        acc1.deposit(0.64);
        System.out.println("Current balance is " + acc1.getBalance());

        acc1.withdrawal(19);
        System.out.println("Current balance is " + acc1.getBalance());

        acc1.withdrawal(100);
        System.out.println("Current balance is " + acc1.getBalance());

        System.out.println("................acc2");
        Account acc2 = new Account();

        System.out.println("Account number is " + acc2.getAccountNumber());
        System.out.println("Current balance is " + acc2.getBalance());
        System.out.println("Account is owned by " + acc2.getCustomerName());
        System.out.println("Owners email address " + acc2.getEmail());
        System.out.println("Owners phone number " + acc2.getPhone());

        System.out.println("................acc3");
        Account acc3 = new Account("Bartek", "bartek@suski.me", 58478);

        System.out.println("Account number is " + acc3.getAccountNumber());
        System.out.println("Current balance is " + acc3.getBalance());
        System.out.println("Account is owned by " + acc3.getCustomerName());
        System.out.println("Owners email address " + acc3.getEmail());
        System.out.println("Owners phone number " + acc3.getPhone());

        System.out.println("................Challenge");
        
        VipCustomer alex = new VipCustomer("Alex", 1000000, "alex@vip.com");
        System.out.println("Account name " + alex.getName());
        System.out.println("Account email " + alex.getEmail());
        System.out.println("Account limit " + alex.getCreditLimit());
        
        VipCustomer john = new VipCustomer("John", "john@vip.com");
        System.out.println("Account name " + john.getName());
        System.out.println("Account email " + john.getEmail());
        System.out.println("Account limit " + john.getCreditLimit()); 
        
        VipCustomer basic = new VipCustomer();
        System.out.println("Account name " + basic.getName());
        System.out.println("Account email " + basic.getEmail());
        System.out.println("Account limit " + basic.getCreditLimit());
    }
}
