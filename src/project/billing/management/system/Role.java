/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.billing.management.system;

/**
 *
 * @author habdelhady
 */
public class Role {
    private Entry data;

    
    public void setData(Entry data) {
        this.data = data;
    }

    public String getName() {
        return data.getName();
    }

    public Entry getData() {
        return data;
    }
    
}

