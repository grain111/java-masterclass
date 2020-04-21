package me.suski;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contacts> contacts = new ArrayList<Contacts>();

    public void addContact(String name, String number) {
        if (!hasName(name)) {
            contacts.add(new Contacts(name, number));
            System.out.println("Contact added");
        } else {
            System.out.println("Contact already exists.");
        }
    }

    public void showContacts() {
        if (contacts.size() == 0) {
            System.out.println("Your contact list is empty.");
        } else {
            System.out.println("Your contact list:");
        }

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i).getName() + ", " + contacts.get(i).getPhoneNumber());
        }
    }

    public void showContact(String name) {
        Contacts contact = getContact(name);
        if (contact == null) {
            System.out.println("No such contact in the list.");
        } else {
            System.out.println("Name: " + contact.getName() + "\nPhone Number: " + contact.getPhoneNumber());
        }
    }

    public void modifyContact(String name, String newName, String newPhoneNumber) {
        Contacts contact = getContact(name);
        if (contact == null) {
            System.out.println("No contact with that name on the list.");
        } else if (hasName(newName)) {
            System.out.println("Contact with that name already exists.");

        } else {
            if (!newName.isEmpty()) {
                contact.setName(newName);
            }
            if (!newPhoneNumber.isEmpty()) {
                contact.setPhoneNumber(newPhoneNumber);
            }
            System.out.println("Contact info updated.");
        }
    }

    public void removeContact(String name) {
        contacts.remove(getContact(name));
    }

    private Contacts getContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    public boolean hasName(String name) {
        return getContact(name) != null;
    }
}
