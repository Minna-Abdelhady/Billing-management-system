/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package project.billing.management.system;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author habdelhady
 */
public class Display_Users extends Application {

    private TableView<User> table = new TableView<User>();
    private final ObservableList<User> data
            = FXCollections.observableArrayList(
                    new User("Jacob", "Smith", "123", "Male", "23", "JacobSmith", "123"),
                    new User("Isabella", "Johnson", "456", "Female", "34", "IsabellaJohnson", "456"),
                    new User("Ethan", "Williams", "122", "Male", "12", "EthanWilliams", "122"),
                    new User("Emma", "Jones", "876", "Female", "21", "EmmaJones", "876"),
                    new User("Michael", "Brown", "333", "Male", "23", "MichaelBrown", "333")
            );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Display Users");
        stage.setWidth(400);
        stage.setHeight(550);

        final Label label = new Label("Users");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(80);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<User, String>("firstName"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(80);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<User, String>("lastName"));

        TableColumn idCol = new TableColumn("Id");
        idCol.setMinWidth(80);
        idCol.setCellValueFactory(
                new PropertyValueFactory<User, String>("Id"));

        TableColumn genderCol = new TableColumn("Gender");
        genderCol.setMinWidth(80);
        genderCol.setCellValueFactory(
                new PropertyValueFactory<User, String>("Gender"));

        TableColumn ageCol = new TableColumn("Age");
        ageCol.setMinWidth(80);
        ageCol.setCellValueFactory(
                new PropertyValueFactory<User, String>("Age"));

        FilteredList<User> flPerson = new FilteredList(data, p -> true);//Pass the data to a filtered list
        table.setItems(flPerson);//Set the table's items using the filtered list
        table.getColumns().addAll(firstNameCol, lastNameCol, idCol, ageCol);

        //Adding ChoiceBox and TextField here!
        ChoiceBox<String> choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll("First Name", "Last Name", "ID","Age");
        choiceBox.setValue("First Name");

        TextField textField = new TextField();
        textField.setPromptText("Search here!");
        textField.textProperty().addListener((obs, oldValue, newValue) -> {
            switch (choiceBox.getValue())//Switch on choiceBox value
            {
                case "First Name":
                    flPerson.setPredicate(p -> p.getFirstName().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by first name
                    break;
                case "Last Name":
                    flPerson.setPredicate(p -> p.getLastName().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by last name
                    break;
                case "Id":
                    flPerson.setPredicate(p -> p.getId().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by email
                    break;
                case "Gender":
                    flPerson.setPredicate(p -> p.getGender().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by email
                    break;
                case "Age":
                    flPerson.setPredicate(p -> p.getAge().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by email
                    break;
            }
        });

        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)
                -> {//reset table and textfield when new choice is selected
            if (newVal != null) {
                textField.setText("");
            }
        });

        HBox hBox = new HBox(choiceBox, textField);//Add choiceBox and textField to hBox
        hBox.setAlignment(Pos.CENTER);//Center HBox
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hBox);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

}
