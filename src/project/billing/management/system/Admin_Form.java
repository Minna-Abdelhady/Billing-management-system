/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package project.billing.management.system;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class Admin_Form extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btnDisplay = new Button("Display all customers");
        btnDisplay.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 30));
        btnDisplay.setOnAction((ActionEvent event) -> {
            primaryStage.close();
            Display_Users nextForm = new Display_Users();
            nextForm.start(primaryStage);
        });

        Button btnSearch = new Button();
        btnSearch.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 30));

        btnSearch.setText("Display Bills");
        btnSearch.setOnAction((ActionEvent event) -> {
            primaryStage.close();
            Display_Bills nextForm = new Display_Bills();
            nextForm.start(primaryStage);
        });

        VBox root = new VBox();
        root.getChildren().addAll(btnDisplay, btnSearch);
        root.setPadding(new Insets(50));
        root.setSpacing(15);

        Scene scene = new Scene(root, 500, 250);

        primaryStage.setTitle("Admin Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
