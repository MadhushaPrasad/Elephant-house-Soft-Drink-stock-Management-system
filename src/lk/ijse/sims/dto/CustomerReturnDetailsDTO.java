/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dto;

/**
 *
 * @author acer
 */
public class CustomerReturnDetailsDTO {
    private String iTD;
    private String CR_ID;
    private String crdid;
    private String date;
    private int qty;
    private double price;

    public CustomerReturnDetailsDTO() {
    }

    public CustomerReturnDetailsDTO(String iTD, String CR_ID, String crdid, String date, int qty, double price) {
        this.iTD = iTD;
        this.CR_ID = CR_ID;
        this.crdid = crdid;
        this.date = date;
        this.qty = qty;
        this.price = price;
    }

    public String getiTD() {
        return iTD;
    }

    public void setiTD(String iTD) {
        this.iTD = iTD;
    }

    public String getCR_ID() {
        return CR_ID;
    }

    public void setCR_ID(String CR_ID) {
        this.CR_ID = CR_ID;
    }

    public String getCrdid() {
        return crdid;
    }

    public void setCrdid(String crdid) {
        this.crdid = crdid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
