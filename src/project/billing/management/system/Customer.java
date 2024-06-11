/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package project.billing.management.system;

import java.io.Serializable;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author habdelhady
 */
public class Customer extends Application implements Serializable {

    @Override
    public void start(Stage primaryStage) {

        Button btnDisplay = new Button("Display all Bills");
        btnDisplay.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 30));
        btnDisplay.setOnAction((ActionEvent event) -> {
            // Go to display bills form
            Display_Bills nextForm = new Display_Bills();
            nextForm.start(primaryStage);
        });

        Button btnSearch = new Button();
        btnSearch.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 30));
        
        btnSearch.setText("Search for bills");
        btnSearch.setOnAction((ActionEvent event) -> {
            Search_Bill nextForm = new Search_Bill();
            try {
                nextForm.start(primaryStage);
            } catch (Exception e) {
                System.out.println("Exception : " + e);
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(btnDisplay, btnSearch);
        root.setPadding(new Insets(50));
        root.setSpacing(15);
        
        Scene scene = new Scene(root, 400, 250);

        primaryStage.setTitle("Hello World!");
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
