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
public class Item {

    private String iID;
    private String vID;
    private String iBID;
    private String MFDate;
    private String EXDate;
    private String ItemName;

    public Item() {
    }

    public Item(String iID, String vID, String iBID, String MFDate, String EXDate, String ItemName) {
        this.iID = iID;
        this.vID = vID;
        this.iBID = iBID;
        this.MFDate = MFDate;
        this.EXDate = EXDate;
        this.ItemName = ItemName;
    }

    public String getiID() {
        return iID;
    }

    public void setiID(String iID) {
        this.iID = iID;
    }

    public String getvID() {
        return vID;
    }

    public void setvID(String vID) {
        this.vID = vID;
    }

    public String getiBID() {
        return iBID;
    }

    public void setiBID(String iBID) {
        this.iBID = iBID;
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
