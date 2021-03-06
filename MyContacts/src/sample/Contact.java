package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contact {

    private StringProperty firstName;
    private StringProperty  lastName;
    private StringProperty  phoneNumber;
    private StringProperty  notes;

    public Contact(String  firstName, String  lastName, String  phoneNumber, String  notes) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.notes = new SimpleStringProperty(notes);
    }

    public Contact(String  firstName, String  lastName, String  phoneNumber) {
        this(firstName, lastName, phoneNumber, " ");
    }

    public Contact() {
        this(" ", " ", " ", " ");
    }

    @Override
    public boolean equals(Object contact) {
        if (contact instanceof Contact) {
            return this.getPhoneNumber().equals(((Contact) contact).getPhoneNumber());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName.get() + '\'' +
                ", lastName='" + lastName.get() + '\'' +
                ", phoneNumber='" + phoneNumber.get() + '\'' +
                ", notes='" + notes.get() + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    public StringProperty notesProperty() {
        return notes;
    }
}
