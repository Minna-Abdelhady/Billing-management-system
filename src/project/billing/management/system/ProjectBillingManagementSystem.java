/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package project.billing.management.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author habdelhady
 */
public class ProjectBillingManagementSystem extends Application {

    @Override
    public void start(Stage primaryStage) {

        // person either customer OR admin 
        //String person;

        Label lbWelcome = new Label("Welcome to our Billing managment System..");
        lbWelcome.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 20));
        //lbWelcome.setFont(Font.font("Lucida Sans Unicode", FontWeight.EXTRA_BOLD, 15));

        FileInputStream in = null;
        try {
            in = new FileInputStream("C:\\Users\\habdelhady\\Desktop\\OOP\\Admin.jpg");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception : " + e);
        }
        Image imagee = new Image(in);
        ImageView view = new ImageView(imagee);
        //Button btnAdmin = new Button("", view);
        Button btnAdmin = new Button("Admin");
        btnAdmin.setGraphic(view);
        btnAdmin.setContentDisplay(ContentDisplay.TOP);
        btnAdmin.setFont(Font.font(15));

        btnAdmin.setOnAction((ActionEvent event) -> {
            System.out.println("Admin");
            MainClass main = new MainClass();
            main.setPerson("Admin");
            primaryStage.close();
            Login_Form nextForm = new Login_Form();
            try {
                nextForm.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(ProjectBillingManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Button btnCustomer = new Button("Customer");
        //btnCustomer.setFont(Font.font("Times New Roman", FontWeight.EXTRA_LIGHT, 30));
        FileInputStream input = null;
        try {
            input = new FileInputStream("C:\\Users\\habdelhady\\Desktop\\OOP\\Customer.jpg");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception : " + e);
        }
        Image image = new Image(input);
        ImageView img = new ImageView(image);
        //Button btnCustomer = new Button("", img);
        Button btnCustomer = new Button("Customer");
        btnCustomer.setGraphic(img);
        btnCustomer.setContentDisplay(ContentDisplay.TOP);
        btnCustomer.setFont(Font.font(15));

        btnCustomer.setOnAction((ActionEvent event) -> {
            System.out.println("Customer");
            MainClass main = new MainClass();
            main.setPerson("Customer");
            primaryStage.close();
            Login_Form nextForm = new Login_Form();
            try {
                nextForm.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(ProjectBillingManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

//        btnAdmin.setMaxWidth(Double.MIN_NORMAL);
//        btnCustomer.setMaxWidth(Double.MAX_VALUE);

        HBox root = new HBox();
        root.setSpacing(15);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(btnAdmin, btnCustomer);

        VBox box = new VBox(15);
        box.getChildren().addAll(lbWelcome, root);
        box.setSpacing(15);
        box.setPadding(new Insets(10));

        Scene scene = new Scene(box, 430, 260);

        primaryStage.setTitle("Welcome");
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
