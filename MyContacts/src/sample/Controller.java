package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private TableColumn lastNameColumn;
    @FXML
    private TableColumn phoneNumberColumn;
    @FXML
    private TableColumn notesColumn;
    @FXML
    private TableColumn firstNameColumn;
    @FXML
    private TableView<Contact> table;

    private ContactData contactData;
    private FXMLLoader loader = new FXMLLoader(getClass().getResource("contactDialog.fxml"));
    private Dialog<ButtonType> dialog = getDialog(this.loader);


    public void initialize() {
        contactData = new ContactData();
        contactData.loadContacts();

        System.out.println(contactData);

        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("lastName"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("phoneNumber"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("notes"));

        table.setItems(contactData.getContacts());
        table.getSelectionModel().selectFirst();
    }

    private Dialog<ButtonType> getDialog(FXMLLoader loader) {

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Add new item");
        dialog.setHeaderText("Input valid data: ");

        try {
            dialog.getDialogPane().setContent(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        return dialog;

    }

    public void showNewItemDialog() {

        Optional<ButtonType> res = dialog.showAndWait();

        if (res.isPresent() && res.get() == ButtonType.OK) {
            contactDialogController c = loader.getController();
            Contact newContact = c.getResContact();
            if (newContact != null) {
                contactData.addContact(newContact);
            }
        } else if (res.get() == ButtonType.CANCEL) {
            System.out.println("Cancel pressed");
        }
    }

    public void showEditDialog() {

        contactDialogController c = loader.getController();
        Contact selected = table.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        c.setData(selected);

        Optional<ButtonType> res = dialog.showAndWait();

        if (res.isPresent() && res.get() == ButtonType.OK) {
            contactData.updateContact(selected, c.getResContact());
        } else if (res.get() == ButtonType.CANCEL) {
            System.out.println("Cancel pressed");
        }

    }

    public void deleteItem() {

        Contact selected = table.getSelectionModel().getSelectedItem();
        contactData.deleteContact(selected);
    }

    public void saveData() {
        contactData.saveContacts();
    }
}
