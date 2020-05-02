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
public class CustomerReturn {

    private String CustID;
    private String sID;
    private String CR_ID;
    private String Reason;

    public CustomerReturn() {
    }

    public CustomerReturn(String CustID, String sID, String CR_ID, String Reason) {
        this.CustID = CustID;
        this.sID = sID;
        this.CR_ID = CR_ID;
        this.Reason = Reason;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getCR_ID() {
        return CR_ID;
    }

    public void setCR_ID(String CR_ID) {
        this.CR_ID = CR_ID;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }
}
