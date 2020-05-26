package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

import java.security.Provider;

public class Controller {

//    private Task<ObservableList<String>> task;
    private Service<ObservableList<String>> service;

    @FXML
    private ListView listView;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressLabel;

    public void initialize() {
//        task = new Task<ObservableList<String>>() {
////            @Override
////            protected ObservableList<String> call() throws Exception {
////                String[] names = {
////                        "Bartek Suski",
////                        "John Snow",
////                        "Jack Jill",
////                        "Max Smith",
////                        "Jane Andrews",
////                        "Bob McDonald"
////                };
////
////                ObservableList<String> employees = FXCollections.observableArrayList();
////
////                for (int i = 0; i < 6; i++) {
////                    employees.add(names[i]);
////                    updateMessage("Added " + names[i]);
////                    updateProgress(i+1, 6);
////                    Thread.sleep(200);
////                }
////                return employees;
////            }
////        };


        service = new EmployeeService();

        listView.itemsProperty().bind(service.valueProperty());
        progressBar.progressProperty().bind(service.progressProperty());
        progressLabel.textProperty().bind(service.messageProperty());

//        service.setOnRunning(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent workerStateEvent) {
//                progressBar.setVisible(true);
//                progressLabel.setVisible(true);
//            }
//        });
//
//        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent workerStateEvent) {
//                progressBar.setVisible(false);
//                progressLabel.setVisible(false);
//            }
//        });

        progressBar.visibleProperty().bind(service.runningProperty());
        progressLabel.visibleProperty().bind(service.runningProperty());


    }

    @FXML
    public void buttonPressed() {
        if (service.getState() == Service.State.SUCCEEDED) {
            service.reset();
            service.start();
        } else if (service.getState() == Service.State.READY) {
            service.start();
        }
    }


}
