package me.suski;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Tim",54.96);
        Customer anotherCustomer = customer;
        anotherCustomer.setBalance(12.58);
        System.out.println(customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        intList.add(5);

        for (int i=0; i<intList.size(); i++) {
            System.out.println(intList.get(i));
        }

        intList.add(1,2);

        for (int i=0; i<intList.size(); i++) {
            System.out.println(intList.get(i));
        }
    }
}
