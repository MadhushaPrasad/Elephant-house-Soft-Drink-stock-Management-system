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
public class OrderType {

    private String oTID;
    private String type;

    public OrderType() {
    }

    public OrderType(String oTID, String type) {
        this.oTID = oTID;
        this.type = type;
    }

    public String getoTID() {
        return oTID;
    }

    public void setoTID(String oTID) {
        this.oTID = oTID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
