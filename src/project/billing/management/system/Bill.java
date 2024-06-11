/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.billing.management.system;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
//import java.util.Scanner;

/**
 *
 * @author habdelhady
 */
public class Bill {

    private final SimpleStringProperty billName = new SimpleStringProperty();
    private final SimpleStringProperty billNumber = new SimpleStringProperty();
    private final SimpleStringProperty billPrice = new SimpleStringProperty();

    Bill(String billName, String billNumber, String billPrice) {
        this.billName.setValue(billName);
        this.billNumber.setValue(billNumber);
        this.billPrice.setValue(billPrice);
    }

    public String getBillName() {
        return billName.get();
    }

    public void setBillName(String fName) {
        billName.set(fName);
    }

    public SimpleStringProperty getFirstNameProperty() {
        return billName;
    }

    public String getBillNumber() {
        return billNumber.get();
    }

    public void setBillNumber(String fName) {
        billNumber.set(fName);
    }

    public SimpleStringProperty getBillNuberProperty() {
        return billNumber;
    }

    public String getBillPrice() {
        return billPrice.get();
    }

    public void setBillPrice(String fName) {
        billPrice.set(fName);
    }

    public SimpleStringProperty getBillPriceProperty() {
        return billPrice;
    }

    // Search for a bill
    public static Bill Search(ArrayList<Bill> billList, String no) {
        for (Bill bill : billList) {
            if (no.equals(bill.billNumber)) {
                return bill;
            }
        }
        return null;
    }

    public static void printBills(ArrayList<Bill> billList) {
        for (int i = 0; i < billList.size(); i++) {
            System.out.println("Bill ID " + billList.get(i).billNumber);
        }
    }

}
