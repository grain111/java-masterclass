package me.suski.todolist;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import me.suski.todolist.datamodel.TodoData;
import me.suski.todolist.datamodel.TodoItem;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {


    private List<TodoItem> todoitems;
    private FilteredList<TodoItem> filteredList;
    private Predicate<TodoItem> allItems;
    private Predicate<TodoItem> todayItems;

    @FXML
    private ListView<TodoItem> todolistView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadLineLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private ToggleButton filterToggleButton;

    public void initialize() {

        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todolistView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });

        listContextMenu.getItems().addAll(deleteMenuItem);


        todolistView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem oldValue, TodoItem newValue) {
                if (newValue != null) {
                    TodoItem item = todolistView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy G").withLocale(Locale.ENGLISH);
                    deadLineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        allItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return true;
            }
        };

        todayItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return item.getDeadline().equals(LocalDate.now());
            }
        };

        filteredList = new FilteredList<>(TodoData.getInstance().getTodoItems(), allItems);
        SortedList<TodoItem> sortedList =  new SortedList<>(filteredList,
                new Comparator<TodoItem>() {
                    @Override
                    public int compare(TodoItem o1, TodoItem o2) {
                        return o1.getDeadline().compareTo(o2.getDeadline());
                    }
                });

//        todolistView.setItems(TodoData.getInstance().getTodoItems());
        todolistView.setItems(sortedList);
        todolistView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todolistView.getSelectionModel().selectFirst();

        todolistView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {
                ListCell<TodoItem> cell = new ListCell<>() {
                    @Override
                    protected void updateItem(TodoItem todoItem, boolean b) {
                        super.updateItem(todoItem, b);
                        if (b) {
                            setText(null);
                        } else {
                            setText(todoItem.getShortDescription());
                            if (todoItem.getDeadline().isBefore(LocalDate.now())) {
                                setTextFill(Color.RED);
                            } else if (todoItem.getDeadline().equals(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.BROWN);
                            }
                        }
                    }
                };

                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty) {
                                cell.setContextMenu(null);
                            } else {
                                cell.setContextMenu(listContextMenu);
                            }
                        }
                );

                return cell;
            }
        });

    }

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add new todo item");
        dialog.setHeaderText("Use this dialog to create a new todo item");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> res = dialog.showAndWait();
        if (res.isPresent() && res.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            TodoItem item = controller.processResults();
            todolistView.getSelectionModel().select(item);
        }
    }

    public void deleteItem(TodoItem item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete todo item");
        alert.setHeaderText("Delete item " + item.getShortDescription());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel.");
        Optional<ButtonType> res = alert.showAndWait();

        if (res.isPresent() && res.get() == ButtonType.OK) {
            TodoData.getInstance().deleteTodoItem(item);
        }
    }

    @FXML
    public void handleFilterButton() {

        TodoItem item = todolistView.getSelectionModel().getSelectedItem();

        if (filterToggleButton.isSelected()) {
            filteredList.setPredicate(todayItems);
            if (filteredList.isEmpty()) {
                itemDetailsTextArea.clear();
                deadLineLabel.setText("");
            } else if (filteredList.contains(item)){
                todolistView.getSelectionModel().select(item);
            } else {
                todolistView.getSelectionModel().selectFirst();
            }
        } else {

            filteredList.setPredicate(allItems);
            todolistView.getSelectionModel().select(item);
        }
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {

        TodoItem item = todolistView.getSelectionModel().getSelectedItem();

        if (item != null) {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteItem(item);
            }
        }
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }

//    @FXML
//    public void handleClickListView() {
//        TodoItem item = todolistView.getSelectionModel().getSelectedItem();
//        itemDetailsTextArea.setText(item.getDetails());
//        deadLineLabel.setText(item.getDeadline().toString());
//    }
}
