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
public class OrderDetailsDTO {
    private String iID;
	private String oID;
	private String qty;
	private String UnitPrice;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(String iID, String oID, String qty, String UnitPrice) {
        this.iID = iID;
        this.oID = oID;
        this.qty = qty;
        this.UnitPrice = UnitPrice;
    }

    public String getiID() {
        return iID;
    }

    public void setiID(String iID) {
        this.iID = iID;
    }

    public String getoID() {
        return oID;
    }

    public void setoID(String oID) {
        this.oID = oID;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(String UnitPrice) {
        this.UnitPrice = UnitPrice;
    }
        
        
}
