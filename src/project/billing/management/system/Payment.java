/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.billing.management.system;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author habdelhady
 */
public class Payment {
    private int id, costumerId;
    private Date date;
    private double amount;
    private String description;
    
    public Payment(int paymentId, int costumerId, Date date, double amount, String description){
        this.id = paymentId;
        this.costumerId = costumerId;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCostumerId(int costumerId) {
        this.costumerId = costumerId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getCostumerId() {
        return costumerId;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
    
    public static Payment editPayment(Payment oldPayment, Payment newPayment){
        oldPayment = newPayment;
        return oldPayment;
    }
    
    public static void printPayments(ArrayList<Payment> paymentList){
        paymentList.forEach((Payment payment) -> {
            System.out.println("Payment ID " + payment.id + "\nCostumer ID " + payment.costumerId);
        });
    }
    
    public static Payment PaymentHelper(ArrayList<Payment> paymentList, int id){
        for(Payment payment : paymentList){
            if(payment.id == id){
                return payment;
            }
        }
        return null;  
    }
    
    public static ArrayList<Payment> deletePayment(ArrayList<Payment> paymentList, int id){
        int ID = Payment.indexOfPayment(paymentList, id);
        paymentList.remove(ID);
        return paymentList;
    }
    
    public static int indexOfPayment(ArrayList<Payment> paymentList, int id){
     for(int i = 0; i < paymentList.size(); i++){
         if(paymentList.get(i).id == id){
         return i;
         }  
     }
     return -1;
    }
    
}
