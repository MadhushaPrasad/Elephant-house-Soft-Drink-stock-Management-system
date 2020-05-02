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
public class CustomEntity {

    private String oid;
    private String date;
    private String customerID;
    private String itemCode;
    private int qty;
    private double unitPrice;
    private String oTID;
     private String MFDate;
    private String EXDate;
    private String ItemName;

    public CustomEntity() {
    }

    public CustomEntity(String oid, String date, String customerID, String itemCode, int qty, double unitPrice, String oTID, String MFDate, String EXDate, String ItemName) {
        this.oid = oid;
        this.date = date;
        this.customerID = customerID;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.oTID = oTID;
        this.MFDate = MFDate;
        this.EXDate = EXDate;
        this.ItemName = ItemName;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getoTID() {
        return oTID;
    }

    public void setoTID(String oTID) {
        this.oTID = oTID;
    }

    public String getMFDate() {
        return MFDate;
    }

    public void setMFDate(String MFDate) {
        this.MFDate = MFDate;
    }

    public String getEXDate() {
        return EXDate;
    }

    public void setEXDate(String EXDate) {
        this.EXDate = EXDate;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }
}
