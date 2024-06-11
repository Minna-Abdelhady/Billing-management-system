package project.billing.management.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author habdelhady
 */
public class MainClass implements Serializable {

    private String person = "Customer";
    private String currentId;
    private ArrayList<Bill> readyBills = new ArrayList<>();

    public MainClass() {
        this.readyBills.add(new Bill("Electricity", "123", "120"));
        this.readyBills.add(new Bill("Water", "456", "210"));
        this.readyBills.add(new Bill("Gas", "789", "43.6"));
        this.readyBills.add(new Bill("Phone", "324", "87.6"));
        this.readyBills.add(new Bill("Internet", "765", "98.5"));
        this.readyBills.add(new Bill("Gas", "546", "43.6"));
        this.readyBills.add(new Bill("Water", "455", "210"));
        this.readyBills.add(new Bill("Electricity", "897", "120"));
        this.readyBills.add(new Bill("Electricity", "900", "902"));
        this.readyBills.add(new Bill("Internet", "567", "98.5"));
        this.readyBills.add(new Bill("Water", "908", "1101"));
        this.readyBills.add(new Bill("Electricity", "203", "654.1"));
        this.readyBills.add(new Bill("Water", "223", "605.3"));
        this.readyBills.add(new Bill("Gas", "654", "880.2"));
        this.readyBills.add(new Bill("Internet", "111", "940.5"));
        this.readyBills.add(new Bill("Water", "564", "34.3"));
        this.readyBills.add(new Bill("Electricity", "123", "544.3"));
        this.readyBills.add(new Bill("Water", "804", "2001.1"));
        this.readyBills.add(new Bill("Gas", "231", "43.6"));
        this.readyBills.add(new Bill("Phone", "405", "87.6"));
        this.readyBills.add(new Bill("Internet", "333", "700.6"));
        this.readyBills.add(new Bill("Gas", "550", "43.6"));
        this.readyBills.add(new Bill("Water", "444", "1002"));
        this.readyBills.add(new Bill("Electricity", "654", "940.4"));
        this.readyBills.add(new Bill("Electricity", "304", "568.4"));
        this.readyBills.add(new Bill("Internet", "777", "98.5"));
        this.readyBills.add(new Bill("Water", "893", "210.09"));
        this.readyBills.add(new Bill("Electricity", "999", "121.1"));
        this.readyBills.add(new Bill("Water", "746", "654.3"));
        this.readyBills.add(new Bill("Gas", "938", "764.2"));
        this.readyBills.add(new Bill("Internet", "237", "90.5"));
        this.readyBills.add(new Bill("Water", "923", "150"));
    }
    
    public ArrayList<Bill> setUsersBills(ArrayList<Bill> userBills) {
        userBills = new ArrayList<>(this.readyBills);
        return userBills;
    }

    public String getCurrentId() {
        return currentId;
    }
    
    public String getPerson() {
        return person;
    }

    public void setCurrentId(String currentId) {
        this.currentId = currentId;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public ArrayList<User> readFromUsersFile() throws FileNotFoundException {
        ArrayList<User> users = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream("C:\\Users\\habdelhady\\Desktop\\Users.dat");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            users = new ArrayList<>((ArrayList<User>) in.readObject());
            //users.add((User));
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found Exception : " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found Exception : " + ex);
        } catch (IOException ex) {
            System.out.println("IOException : " + ex);
        }
        return users;
    }

    public ArrayList<Bill> billsOfCurrentUser(String id) {
        try {
            ArrayList<User> users = new ArrayList<>(readFromUsersFile());
            ArrayList<Bill> userBills;
            for (User user : users) {
                if (user.getId().equals(id)) {
                    userBills = new ArrayList<>(user.getBills());
                    return userBills;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exception : " + e);
        }
        return null;
    }

    public void write2UsersFile(ArrayList<User> users) throws FileNotFoundException {
        try {
            FileOutputStream outputstream = new FileOutputStream("C:\\Users\\habdelhady\\Desktop\\Users.dat");
            ObjectOutputStream out;
            out = new ObjectOutputStream(outputstream);
            out.writeObject(users);
            out.close();
            System.out.println("User Added successfully ");
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found Exception : " + ex);
        } catch (IOException ex) {
            System.out.println("IOException : " + ex);
        }
    }

    public Boolean repeatedId(User user) throws FileNotFoundException {
        ArrayList<User> customers = new ArrayList<>(readFromUsersFile());
        for (int i = 0; i < customers.size(); i++) {
            if (user.getId().equals(customers.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    public Boolean logInConfirmation(String fname, String lname, String username, String password) throws FileNotFoundException {
        ArrayList<User> customers = new ArrayList<>(readFromUsersFile());
        // counter will be 3 if the user exists
        // as there are 3 attributes for the user to log in
        int counter;
        for (int i = 0; i < customers.size(); i++) {
            counter = 0;
            if (fname.equals(customers.get(i).getFirstName())) {
                counter++;
            }
            if (username.equals(customers.get(i).getUsername())) {
                counter++;
            }
            if (password.equals(customers.get(i).getPassword())) {
                counter++;
            }
            // check if all the conditions are true
            // if they are all true return true
            if (counter == 3) {
                this.setCurrentId(customers.get(i).getId());
                return true;
            }
        }
        // we did not find any user with these attributes
        return false;
    }
}
