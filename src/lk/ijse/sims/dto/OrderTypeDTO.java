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
public class OrderTypeDTO {
     private String oTID;
    private String type;

    public OrderTypeDTO() {
    }

    public OrderTypeDTO(String oTID, String type) {
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
