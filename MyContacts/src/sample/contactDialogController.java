package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class contactDialogController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextArea notesField;


    public Contact getResContact() {
        if (!firstNameField.getText().isEmpty() &&
            !lastNameField.getText().isEmpty() &&
            !phoneNumberField.getText().isEmpty()) {

            return new Contact(firstNameField.getText(),
                    lastNameField.getText(),
                    phoneNumberField.getText(),
                    notesField.getText());
        }
        return null;
    }

    public void setData(Contact contact) {
        firstNameField.setText(contact.getFirstName());
        lastNameField.setText(contact.getLastName());
        phoneNumberField.setText(contact.getPhoneNumber());
        notesField.setText(contact.getNotes());
    }
}
