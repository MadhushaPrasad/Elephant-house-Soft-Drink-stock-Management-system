/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dto;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class OrdersDTO {
    private String CustID;
    private String oID;
    private String oTID;
    private String date;
    private ArrayList<OrderDetailsDTO> orderDetails = new ArrayList<>();

    public OrdersDTO() {
    }

    public OrdersDTO(String CustID, String oID, String oTID, String date) {
        this.CustID = CustID;
        this.oID = oID;
        this.oTID = oTID;
        this.date = date;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }

    public String getoID() {
        return oID;
    }

    public void setoID(String oID) {
        this.oID = oID;
    }

    public String getoTID() {
        return oTID;
    }

    public void setoTID(String oTID) {
        this.oTID = oTID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<OrderDetailsDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetailsDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
