/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package project.billing.management.system;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author habdelhady
 */
public class Admin_Display extends Application {
    
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

    //public static final ObservableList names = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("Bills");
        label.setFont(new Font("Arial", 30));

        table.setEditable(true);

        TableColumn UserNameCol = new TableColumn("User Name");
        UserNameCol.setMinWidth(100);
        UserNameCol.setCellValueFactory(
                new PropertyValueFactory<Bill, String>("UserName"));

        TableColumn UserIdCol = new TableColumn("ID");
        UserIdCol.setMinWidth(100);
        UserIdCol.setCellValueFactory(
                new PropertyValueFactory<Bill, String>("UserId"));

        TableColumn UserGenederCol = new TableColumn("Gender");
        UserGenederCol.setMinWidth(100);
        UserGenederCol.setCellValueFactory(
                new PropertyValueFactory<Bill, String>("UserGender"));

        FilteredList<Bill> flPerson = new FilteredList(data, p -> true);//Pass the data to a filtered list
        table.setItems(flPerson);//Set the table's items using the filtered list
        table.getColumns().addAll(UserNameCol, UserIdCol, UserGenederCol);

        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        //vbox.getChildren().addAll(label, table, hBox);
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
