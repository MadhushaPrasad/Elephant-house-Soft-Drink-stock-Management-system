/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.tablemodel;

/**
 *
 * @author acer
 */
public class InvoiceTM {
    private String Item_ID;
    private String Item_Name;
    private double Unite_Price;
    private int QTY;
    private double total;

    public InvoiceTM() {
    }

    public InvoiceTM(String Item_ID, String Item_Name, double Unite_Price, int QTY, double total) {
        this.Item_ID = Item_ID;
        this.Item_Name = Item_Name;
        this.Unite_Price = Unite_Price;
        this.QTY = QTY;
        this.total = total;
    }

    public String getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(String Item_ID) {
        this.Item_ID = Item_ID;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String Item_Name) {
        this.Item_Name = Item_Name;
    }

    public double getUnite_Price() {
        return Unite_Price;
    }

    public void setUnite_Price(double Unite_Price) {
        this.Unite_Price = Unite_Price;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
