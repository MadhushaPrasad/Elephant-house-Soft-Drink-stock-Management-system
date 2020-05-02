/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.entity;

/**
 *
 * @author dell
 */
public class Item_Batch {

    private String sID;
    private String iBID;
    private String mfDate;
    private String eXDATE;
    private double Price;
    

    public Item_Batch() {
    }

    public Item_Batch(String sID, String iBID, String mfDate, String eXDATE, double Price) {
        this.sID = sID;
        this.iBID = iBID;
        this.mfDate = mfDate;
        this.eXDATE = eXDATE;
        this.Price = Price;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getiBID() {
        return iBID;
    }

    public void setiBID(String iBID) {
        this.iBID = iBID;
    }

    public String getMfDate() {
        return mfDate;
    }

    public void setMfDate(String mfDate) {
        this.mfDate = mfDate;
    }

    public String geteXDATE() {
        return eXDATE;
    }

    public void seteXDATE(String eXDATE) {
        this.eXDATE = eXDATE;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    
}
