/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.billing.management.system;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;

/**
 *
 * @author habdelhady
 */
public class Entry {
    private String name;
    private int id;
    private String email;
    private String password;

    public File usersFile = new File("UserEmails.txt");
    public File adminsFile = new File("AdminsEmails.txt");

    public Entry(String name, int id, String email, String password) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

// key =1 if user, =2 if admin
    public boolean logIn(Scanner input, int key) {
        try {
            System.out.println("Enter your email ");
            String e = input.next();
            System.out.println("Enter your password ");
            String p = input.next();
            Scanner fileInput;
            if (key == 1) {
                fileInput = new Scanner(usersFile);
                while (fileInput.hasNext()) {
                    String na = fileInput.next();
                    int iD = fileInput.nextInt();
                    String em = fileInput.next();
                    String pass = fileInput.next();
                    if (e.equals(em) && p.equals(pass)) {
                        return true;
                    }
                }
            } else if (key == 2) {
                fileInput = new Scanner(adminsFile);
                while (fileInput.hasNext()) {
                    String na = fileInput.next();
                    int iD = fileInput.nextInt();
                    String em = fileInput.next();
                    String pass = fileInput.next();
                    if (e.equals(em) && p.equals(pass)) {
                        return true;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        return false;
    }

    public void signUp(Scanner input, int key) {
        try {
            System.out.println("Enter your name ");
            String na = input.next();
            System.out.println("Enter your id ");
            int id = input.nextInt();
            System.out.println("Enter your email ");
            String e = input.next();
            while (!e.contains("@gmail.com")) {
                System.out.println("Enter a right form of email");
                e = input.next();
            }
            System.out.println("Enter your password ");
            String p = input.next();
            BufferedWriter write;
            // key =1 if user, =2 if admin
            if (key == 1) {
                write = new BufferedWriter(new FileWriter(usersFile, true));
            write.write(na + " " + id + " " + e + " " + p + "\n");
            write.close();
            } else if (key == 2) {
                write = new BufferedWriter(new FileWriter(adminsFile, true));
            write.write(na + " " + id + " " + e + " " + p + "\n");
            write.close();
            }
        } catch (Exception ex) {
            System.out.print("Error");
        }
    }
}

