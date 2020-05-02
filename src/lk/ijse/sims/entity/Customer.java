/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.entity;

/**
 *
 * @author acer
 */
public class Customer {

    private String CustID;
    private String FName;
    private String LName;
    private String Address;
    private String TelNumber;

    public Customer() {
    }

    public Customer(String CustID, String FName, String LName, String Address, String TelNumber) {
        this.CustID = CustID;
        this.FName = FName;
        this.LName = LName;
        this.Address = Address;
        this.TelNumber = TelNumber;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getTelNumber() {
        return TelNumber;
    }

    public void setTelNumber(String TelNumber) {
        this.TelNumber = TelNumber;
    }
    
    
}
