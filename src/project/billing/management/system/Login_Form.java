/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package project.billing.management.system;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author habdelhady
 */
public class Login_Form extends Application implements Serializable {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Log-in Form");
        // Create the registration form grid pane
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();
        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);
        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40));
        // Set the horizontal gap between columns
        gridPane.setHgap(10);
        // Set the vertical gap between rows
        gridPane.setVgap(10);
        /* Add Column Constraints
        columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);*/

        // Add UI controls to the registration form grid pane
        // Add Header
        Label headerLabel = new Label("Log in");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
        // Add Name Label
        Label nameLabel = new Label("Full Name : ");
        gridPane.add(nameLabel, 0, 1);
        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1, 1);
        // Add userName Label
        Label userNameLabel = new Label("User Name : ");
        gridPane.add(userNameLabel, 0, 2);
        // Add userName Text Field
        TextField userNameField = new TextField();
        userNameField.setPrefHeight(40);
        gridPane.add(userNameField, 1, 2);
        // Add Password Label
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 3);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 3);

        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));

        // add the sign up label
        Label lbDont = new Label("You do not have an e-mail ?");
        Label lbSignup = new Label("SignUp");
        //Setting the color of the text
        lbSignup.setTextFill(Color.BLUE);
        //Underlining the text
        lbSignup.setUnderline(true);

        gridPane.add(lbDont, 0, 5);
        gridPane.add(lbSignup, 1, 5);

        lbSignup.setOnMouseClicked((mouseEvent) -> {
            primaryStage.close();
            //ProjectBillingManagementSystem form = new ProjectBillingManagementSystem();
            Registration_Form nextForm = new Registration_Form();
            nextForm.start(primaryStage);
        });

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!!!", "Please enter your name");
                    return;
                }
                if (userNameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!!!", "Please enter your userName");
                    return;
                }
                if (passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!!!", "Please enter a password");
                    return;
                }

                String name = nameField.getText();
                String newName = name.trim();
                int indexOfSpace = newName.indexOf(" ");
                String fname = newName.substring(0, indexOfSpace);
                String lname = newName.substring(indexOfSpace + 1);
                String username = userNameField.getText();
                String password = passwordField.getText();
                MainClass main = new MainClass();
                try {
                    if (main.logInConfirmation(fname, lname, username, password)) {
                        showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Logged in Successfully!", "Welcome " + nameField.getText());
                        String person = main.getPerson();
                        if (person.equals("Customer")) {
                            primaryStage.close();
                            Customer nextForm = new Customer();
                            nextForm.start(primaryStage);
                        } else {
                            primaryStage.close();
                            Admin_Form nextForm = new Admin_Form();
                            nextForm.start(primaryStage);
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("User does not exist");
                        alert.setHeaderText("You either do not have an account OR entered wrong data");
                        alert.setContentText("Enter correct data or SIGN UP");
                        alert.showAndWait();
                        //Login_Form n = new Login_Form();
                        //n.start(primaryStage);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Login_Form.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Login_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 400, 300);
        // Set the scene in primary stage	
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
