package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = loader.load();
        primaryStage.setTitle("My Contacts");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Controller c = loader.getController();
        c.saveData();
    }
}
