/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package project.billing.management.system;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author habdelhady
 */
public class Search_Bill extends Application implements Serializable {

    //MainClass main = new MainClass();
    //String id = main.getCurrentId();
    //ArrayList<Bill> bills = new ArrayList<>(main.billsOfCurrentUser(id));
    private TableView<Bill> table = new TableView<>();
    //final ObservableList<Bill> data = FXCollections.observableArrayList(bills);

    /*public void Search_Bill() {
        for (Bill bill : bills) {
            data.add(bill);
        }
    }*/
    private final ObservableList<Bill> data
            = FXCollections.observableArrayList(
                    new Bill("Electricity", "123", "120"),
                    new Bill("Water", "456", "210"),
                    new Bill("Gas", "789", "43.6"),
                    new Bill("Phone", "324", "87.6"),
                    new Bill("Internet", "765", "98.5"),
                    new Bill("Gas", "546", "43.6"),
                    new Bill("Water", "455", "210"),
                    new Bill("Electricity", "897", "120"),
                    new Bill("Electricity", "900", "902"),
                    new Bill("Internet", "567", "98.5"),
                    new Bill("Water", "908", "1101"),
                    new Bill("Electricity", "203", "654.1"),
                    new Bill("Water", "223", "605.3"),
                    new Bill("Gas", "654", "880.2"),
                    new Bill("Internet", "111", "940.5"),
                    new Bill("Water", "564", "34.3"),
                    new Bill("Electricity", "123", "544.3"),
                    new Bill("Water", "804", "2001.1"),
                    new Bill("Gas", "231", "43.6"),
                    new Bill("Phone", "405", "87.6"),
                    new Bill("Internet", "333", "700.6"),
                    new Bill("Gas", "550", "43.6"),
                    new Bill("Water", "444", "1002"),
                    new Bill("Electricity", "654", "940.4"),
                    new Bill("Electricity", "304", "568.4"),
                    new Bill("Internet", "777", "98.5"),
                    new Bill("Water", "893", "210.09"),
                    new Bill("Electricity", "999", "121.1"),
                    new Bill("Water", "746", "654.3"),
                    new Bill("Gas", "938", "764.2"),
                    new Bill("Internet", "237", "90.5"),
                    new Bill("Water", "923", "150")
            );
    // private final ObservableList<Bill> data = FXCollections.observableArrayList(bills);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("Bills");
        label.setFont(new Font("Arial", 30));

        table.setEditable(true);

        TableColumn billNameCol = new TableColumn("Bill Name");
        billNameCol.setMinWidth(100);
        billNameCol.setCellValueFactory(
                new PropertyValueFactory<Bill, String>("billName"));

        TableColumn billNumberCol = new TableColumn("Bill Number");
        billNumberCol.setMinWidth(100);
        billNumberCol.setCellValueFactory(
                new PropertyValueFactory<Bill, String>("billNumber"));

        TableColumn billPriceCol = new TableColumn("Bill Price");
        billPriceCol.setMinWidth(100);
        billPriceCol.setCellValueFactory(
                new PropertyValueFactory<Bill, String>("billPrice"));

        FilteredList<Bill> flPerson = new FilteredList(data, p -> true);//Pass the data to a filtered list
        table.setItems(flPerson);//Set the table's items using the filtered list
        table.getColumns().addAll(billNameCol, billNumberCol, billPriceCol);

        //Adding ChoiceBox and TextField here!
        ChoiceBox<String> choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll("Bill Name", "Bill Number", "Bill Price");
        choiceBox.setValue("Bill Name");

        TextField textField = new TextField();
        textField.setPromptText("Search here!");
        textField.textProperty().addListener((obs, oldValue, newValue) -> {
            switch (choiceBox.getValue())//Switch on choiceBox value
            {
                case "Bill Name":
                    flPerson.setPredicate(p -> p.getBillName().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by first name
                    break;
                case "Bill Number":
                    flPerson.setPredicate(p -> p.getBillNumber().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by last name
                    break;
                case "Bill Price":
                    flPerson.setPredicate(p -> p.getBillPrice().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by email
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
