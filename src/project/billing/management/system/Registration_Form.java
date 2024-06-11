/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package project.billing.management.system;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author habdelhady
 */
public class Registration_Form extends Application implements Serializable {

    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        Label lbEnter = new Label("Enter Your Data !!");
        GridPane.setHalignment(lbEnter, HPos.CENTER);
        //lbEnter.setFont(Font.font("Verdana",FontWeight.EXTRA_BOLD,15));
        lbEnter.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
        pane.addRow(0, lbEnter);

        Label lbFname = new Label("First Name : ");
        pane.add(lbFname, 0, 1);
        TextField txtFieldFname = new TextField();
        pane.add(txtFieldFname, 1, 1);

        Label lbLname = new Label("Last Name : ");
        pane.add(lbLname, 0, 2);
        TextField txtFieldLname = new TextField();
        pane.add(txtFieldLname, 1, 2);

        Label lbId = new Label("ID : ");
        pane.add(lbId, 0, 3);
        TextField txtFieldId = new TextField();
        pane.add(txtFieldId, 1, 3);

        Label lbGender = new Label("Gender : ");
        pane.add(lbGender, 0, 4);
        final ToggleGroup groupGender = new ToggleGroup();
        RadioButton rbFemale = new RadioButton("Female");
        rbFemale.setToggleGroup(groupGender);
        RadioButton rbMale = new RadioButton("Male");
        rbMale.setToggleGroup(groupGender);
        VBox radioButtons = new VBox();
        radioButtons.getChildren().addAll(rbFemale, rbMale);
        pane.add(radioButtons, 1, 4);

        Label lbAge = new Label("Age : ");
        pane.add(lbAge, 0, 5);
        TextField txtFieldAge = new TextField();
        pane.add(txtFieldAge, 1, 5);

        Label lbUserName = new Label("UserName : ");
        pane.add(lbUserName, 0, 6);
        TextField txtFieldUserName = new TextField();
        pane.add(txtFieldUserName, 1, 6);

        Label lbPass = new Label("Password : ");
        pane.add(lbPass, 0, 7);
        PasswordField passField = new PasswordField();
        pane.add(passField, 1, 7);

        Button btnSubmit = new Button();
        pane.add(btnSubmit, 1, 8);
        btnSubmit.setText("Add Customer");
        btnSubmit.setFont(Font.font("Verdana"));
        GridPane.setHalignment(btnSubmit, HPos.RIGHT);

        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (txtFieldFname.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Error!!!", "Please enter your first name");
                    return;
                }
                if (txtFieldLname.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Error!!!", "Please enter your last name");
                    return;
                }
                if (txtFieldId.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Error!!!", "Please enter your ID");
                    return;
                }
                if (((RadioButton) groupGender.getSelectedToggle()).getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Error!!!", "Please select your gender");
                    return;
                }
                if (txtFieldAge.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Error!!!", "Please enter your age");
                    return;
                }
                if (txtFieldUserName.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Error!!!", "Please enter your username");
                    return;
                }
                if (passField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Error!!!", "Please enter your password");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, "Logged in Successfully!", "Welcome " + txtFieldFname.getText() + txtFieldLname.getText());

                String fname = txtFieldFname.getText();
                String lname = txtFieldLname.getText();
                String id = txtFieldId.getText();
                RadioButton selectedGender = (RadioButton) groupGender.getSelectedToggle();
                String gender = selectedGender.getText();
                System.out.println(gender);
                String age = txtFieldAge.getText();
                String username = txtFieldUserName.getText();
                String password = passField.getText();

                ArrayList<Bill> bills = new ArrayList<>();
                bills.add(new Bill("Electricity", "123", "120"));
                bills.add(new Bill("Water", "456", "210"));
                bills.add(new Bill("Gas", "789", "43.6"));
                bills.add(new Bill("Phone", "324", "87.6"));
                bills.add(new Bill("Internet", "765", "98.5"));
                bills.add(new Bill("Gas", "546", "43.6"));
                bills.add(new Bill("Water", "455", "210"));
                bills.add(new Bill("Electricity", "897", "120"));
                bills.add(new Bill("Electricity", "900", "902"));
                bills.add(new Bill("Internet", "567", "98.5"));
                bills.add(new Bill("Water", "908", "1101"));
                bills.add(new Bill("Electricity", "203", "654.1"));
                bills.add(new Bill("Water", "223", "605.3"));
                bills.add(new Bill("Gas", "654", "880.2"));
                bills.add(new Bill("Internet", "111", "940.5"));
                bills.add(new Bill("Water", "564", "34.3"));
                bills.add(new Bill("Electricity", "123", "544.3"));
                bills.add(new Bill("Water", "804", "2001.1"));
                bills.add(new Bill("Gas", "231", "43.6"));
                bills.add(new Bill("Phone", "405", "87.6"));
                bills.add(new Bill("Internet", "333", "700.6"));
                bills.add(new Bill("Gas", "550", "43.6"));
                bills.add(new Bill("Water", "444", "1002"));
                bills.add(new Bill("Electricity", "654", "940.4"));
                bills.add(new Bill("Electricity", "304", "568.4"));
                bills.add(new Bill("Internet", "777", "98.5"));
                bills.add(new Bill("Water", "893", "210.09"));
                bills.add(new Bill("Electricity", "999", "121.1"));
                bills.add(new Bill("Water", "746", "654.3"));
                bills.add(new Bill("Gas", "938", "764.2"));
                bills.add(new Bill("Internet", "237", "90.5"));
                bills.add(new Bill("Water", "923", "150"));

                MainClass main = new MainClass();
                main.setCurrentId(id);
                User user1;
                user1 = new User(fname, lname, id, gender, age, username, password);
                // fill the bills of the user with values
                //user1.setBills(main.setUsersBills(user1.getBills()));

//                System.out.println(fname + " " + lname + " " + id + " " );
//                System.out.println(gender + " " + age + " " + username + " " + password);
                try {
                    if (main.repeatedId(user1)) {
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("WARNING !!");
                        alert.setHeaderText("This User already exists ");
                        alert.setContentText("Login you already have an email");
                        alert.showAndWait();
                        primaryStage.close();
                        Login_Form nextForm = new Login_Form();
                        nextForm.start(primaryStage);
                    } else {
                        ArrayList<User> users = new ArrayList<>(main.readFromUsersFile());
                        users.add(user1);
//                        ArrayList<User> users = new ArrayList<>();
//                        users.add(user1);
                        main.write2UsersFile(users);
                        Alert alert = new Alert(AlertType.CONFIRMATION);
                        alert.setTitle("Congratulations");
                        alert.setHeaderText("You have made an account successfully ");
                        alert.setContentText("You can log in if you want to open again");
                        alert.showAndWait();
                        // go to the next form
                        MainClass mainClass = new MainClass();
                        String person = mainClass.getPerson();
                        System.out.println("Person " + person);
                        if (person.equals("Customer")) {
                            primaryStage.close();
                            Customer nextForm = new Customer();
                            nextForm.start(primaryStage);
                        } else {
                            primaryStage.close();
                            Admin_Form nextForm = new Admin_Form();
                            nextForm.start(primaryStage);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Registration_Form.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Registration_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Scene scene = new Scene(pane);

        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
