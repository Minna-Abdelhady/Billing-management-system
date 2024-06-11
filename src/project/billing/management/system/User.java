package project.billing.management.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author habdelhady
 */
public final class User extends Role implements Serializable {

    /*private final SimpleStringProperty firstName = new SimpleStringProperty();;
    private final SimpleStringProperty lastName = new SimpleStringProperty();;
    private final SimpleStringProperty id = new SimpleStringProperty();;
    private final SimpleStringProperty gender = new SimpleStringProperty();;
    private final SimpleStringProperty age = new SimpleStringProperty();;
    private final SimpleStringProperty username = new SimpleStringProperty();;
    private final SimpleStringProperty password = new SimpleStringProperty();;
    private ArrayList<Bill> bills;
    private String payments;
    
    public User(String firstName, String lastName, String id, String gender, String age, String username, String password) {
        this.firstName.setValue(firstName);
        this.lastName.setValue(lastName);
        this.id.setValue(id);
        this.gender.setValue(gender);
        this.age.setValue(age);
        this.username.setValue(username);
        this.password.setValue(password);
        bills = new ArrayList<>();
        MainClass main = new MainClass();
        main.setUsersBills(bills);
        this.setBills();
    }

    public User(String firstName, String lastName, String id, String gender, String age, String username, String password, ArrayList<Bill> bills) {
        this.firstName.setValue(firstName);
        this.lastName.setValue(lastName);
        this.id.setValue(id);
        this.gender.setValue(gender);
        this.age.setValue(age);
        this.username.setValue(username);
        this.password.setValue(password);
        this.bills = bills;
    }*/
 /*public void setBills(){
        this.bills.add(new Bill("Electricity", "123", "120"));
        this.bills.add(new Bill("Water", "456", "210"));
        this.bills.add(new Bill("Gas", "789", "43.6"));
        this.bills.add(new Bill("Phone", "324", "87.6"));
        this.bills.add(new Bill("Internet", "765", "98.5"));
        this.bills.add(new Bill("Gas", "546", "43.6"));
        this.bills.add(new Bill("Water", "455", "210"));
        this.bills.add(new Bill("Electricity", "897", "120"));
        this.bills.add(new Bill("Electricity", "900", "902"));
        this.bills.add(new Bill("Internet", "567", "98.5"));
        this.bills.add(new Bill("Water", "908", "1101"));
        this.bills.add(new Bill("Electricity", "203", "654.1"));
        this.bills.add(new Bill("Water", "223", "605.3"));
        this.bills.add(new Bill("Gas", "654", "880.2"));
        this.bills.add(new Bill("Internet", "111", "940.5"));
        this.bills.add(new Bill("Water", "564", "34.3"));
        this.bills.add(new Bill("Electricity", "123", "544.3"));
        this.bills.add(new Bill("Water", "804", "2001.1"));
        this.bills.add(new Bill("Gas", "231", "43.6"));
        this.bills.add(new Bill("Phone", "405", "87.6"));
        this.bills.add(new Bill("Internet", "333", "700.6"));
        this.bills.add(new Bill("Gas", "550", "43.6"));
        this.bills.add(new Bill("Water", "444", "1002"));
        this.bills.add(new Bill("Electricity", "654", "940.4"));
        this.bills.add(new Bill("Electricity", "304", "568.4"));
        this.bills.add(new Bill("Internet", "777", "98.5"));
        this.bills.add(new Bill("Water", "893", "210.09"));
        this.bills.add(new Bill("Electricity", "999", "121.1"));
        this.bills.add(new Bill("Water", "746", "654.3"));
        this.bills.add(new Bill("Gas", "938", "764.2"));
        this.bills.add(new Bill("Internet", "237", "90.5"));
        this.bills.add(new Bill("Water", "923", "150"));
    }*/
    private final SimpleStringProperty firstName = new SimpleStringProperty();
    private final SimpleStringProperty lastName = new SimpleStringProperty();
    private final SimpleStringProperty id = new SimpleStringProperty();
    private final SimpleStringProperty gender = new SimpleStringProperty();
    private final SimpleStringProperty age = new SimpleStringProperty();
    private final SimpleStringProperty username = new SimpleStringProperty();
    private final SimpleStringProperty password = new SimpleStringProperty();
    private ArrayList<Bill> bills;
    private String payments;

    User(String fName, String lName, String id, String gender, String age, String username, String password) {
        this.firstName.setValue(fName);
        this.lastName.setValue(lName);
        this.id.setValue(id);
        this.gender.setValue(gender);
        this.age.setValue(age);
        this.username.setValue(username);
        this.password.setValue(password);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public SimpleStringProperty getFirstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String fName) {
        lastName.set(fName);
    }

    public SimpleStringProperty getLastNameProperty() {
        return lastName;
    }

    public String getId() {
        return id.get();
    }

    public void setId(String fName) {
        id.set(fName);
    }

    public SimpleStringProperty getIdProperty() {
        return id;
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String fName) {
        gender.set(fName);
    }

    public SimpleStringProperty getGenderProperty() {
        return gender;
    }

    public String getAge() {
        return age.get();
    }

    public void setAge(String fName) {
        age.set(fName);
    }

    public SimpleStringProperty getAgeProperty() {
        return age;
    }

    public SimpleStringProperty getUsername() {
        return username;
    }

    public SimpleStringProperty getPassword() {
        return password;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void addBill(Scanner input) {
        System.out.println("Enter bill name");
        String name = input.next();
        System.out.println("Enter bill number");
        String num = input.next();
        System.out.println("Enter bill price");
        String price = input.next();
        Bill bill_1 = new Bill(name, num, price);
        bills.add(bill_1);
        System.out.println("Bill added successfully ");
    }

    public void remove(int billno) {
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getBillNumber().equals(billno)) {
                bills.remove(i);
            }
        }
        System.out.println("Bill removed successfully ");
    }

    public void display(int billno) {
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getBillNumber().equals(billno)) {
                System.out.println("Bills number " + bills.get(i).getBillNumber());
            }
        }
    }

    public void displayAll() {
        if (bills.isEmpty()) {
            System.out.println("No Bills ");
            return;
        }
        for (int i = 0; i < bills.size(); i++) {
            System.out.println("Bills number " + bills.get(i).getBillNumber());
        }
    }

    public Boolean search(int billno) {
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getBillNumber().equals(billno)) {
                return true;
            }
        }
        return false;
    }

}
