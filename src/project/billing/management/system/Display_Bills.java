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
public class Display_Bills extends Application implements Serializable {

    private TableView<Bill> table = new TableView<>();
    //final ObservableList<Bill> data = FXCollections.observableArrayList(bills);

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

    public static final ObservableList names = FXCollections.observableArrayList();

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

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
