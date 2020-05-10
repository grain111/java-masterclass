package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public Button byeButton;
    @FXML
    public Button helloButton;
    @FXML
    public Label ourLabel;
    @FXML
    private TextField nameField;
    @FXML
    private CheckBox ourCheckBox;

    @FXML
    public void initialize() {
        disableButtons();
    }

    @FXML
    public void handleChange() {
        System.out.println("The checkbox is " +
                (ourCheckBox.isSelected() ? "checked" : "not checked"));
    }

    private void disableButtons() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {

        if (nameField.getText().isEmpty()) {
            helloButton.setDisable(true);
        }

        if (e.getSource().equals(helloButton)) {
            System.out.println("Hello, " + nameField.getText());
        } else if (e.getSource().equals(byeButton)) {
            System.out.println("Bye, " + nameField.getText());
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I'm going to sleep on " + s);
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("I'm changing label on " + s);
                            ourLabel.setText("We did something");
                        }
                    });

                } catch (InterruptedException event) {

                }
            }
        };

        new Thread(task).start();



        if (ourCheckBox.isSelected()) {
            nameField.clear();
            disableButtons();
        }
    }

    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() | text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }
}
