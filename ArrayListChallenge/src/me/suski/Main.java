package me.suski;

import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static MobilePhone mobile = new MobilePhone();

    public static void main(String[] args) {
        printOptions();
        boolean exit = false;
        while (!exit) {
            System.out.print("Option: ");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 0:
                    printOptions();
                    break;
                case 1:
                    mobile.showContacts();
                    break;
                case 2:
                    showEntry();
                    break;
                case 3:
                    addEntry();
                    break;
                case 4:
                    modifyEntry();
                    break;
                case 5:
                    removeEntry();
                    break;
                case 6:
                    exit = true;
                    break;
            }
        }

    }
    public static void printOptions() {
        System.out.println("Options: ");
        System.out.println("0 - Display options");
        System.out.println("1 - Display contact list");
        System.out.println("2 - Display contact info");
        System.out.println("3 - Add contact to the list");
        System.out.println("4 - Modify contact in the list");
        System.out.println("5 - Remove contact from the list");
        System.out.println("6 - Exit");
    }

    public static void showEntry() {
        System.out.print("Input contact name: ");
        mobile.showContact(s.nextLine());
    }

    public static void addEntry() {
        System.out.print("Input contact name: ");
        String name = s.nextLine();

        System.out.print("Input contact phone number: ");
        String number = s.nextLine();

        mobile.addContact(name, number);
    }

    public static void modifyEntry() {
        System.out.print("Input contact name to be modified: ");
        String name = s.nextLine();

        System.out.print("Input new contact name (leave empty if you don't want to change it): ");
        String newName = s.nextLine();

        System.out.print("Input new contact phone number (leave empty if you don't want to change it): ");
        String newNumber = s.nextLine();

        mobile.modifyContact(name, newName, newNumber);
    }

    public static void removeEntry() {
        System.out.print("Input contact name to be removed: ");
        String name = s.nextLine();

        mobile.removeContact(name);
    }
}
